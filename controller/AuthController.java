
package com.example.restapiassign2.controller;

import com.example.restapiassign2.CustomResponse;
import com.example.restapiassign2.models.UseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author kimberlycarpizo
 */
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/auth", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity login(@RequestBody UseModel user)
    {


       try{

           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

           var response = new CustomResponse( "Login Successfully", null);

           return new ResponseEntity( response, HttpStatus.OK);

       }

       catch (BadCredentialsException ex)
       {


           var response = new CustomResponse( "Incorrect username/password", null);

           return new ResponseEntity( response, HttpStatus.UNAUTHORIZED);
       }



    }
    
}
