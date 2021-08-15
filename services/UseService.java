
package com.example.restapiassign2.services;


import com.example.restapiassign2.models.UseModel;
import com.example.restapiassign2.models.UseRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author kimberlycarpizo
 */
@Service
public class UseService implements UserDetailsService{
    @Autowired
    private UseRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bPasswordEncoder;

    public UseModel addUser(UseModel user)
    {


        String ePassword = bPasswordEncoder.encode(user.getPassword());

        user.setPassword(ePassword);

        UseModel iUser = userRepository.insert(user);

        return iUser;
    }

    public List<UseModel> getUsers()
    {
    return userRepository.findAll();
    }

    public Optional<UseModel> getUser(String id)
    {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException


    {


         UseModel foundUser = userRepository.findByEmail(email);

         String e = foundUser.getEmail();
         String password = foundUser.getPassword();

         return new User(e, password, new ArrayList<>());


    }
}
