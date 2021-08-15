package com.example.restapiassign2.config;

import com.example.restapiassign2.services.UseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter


{
    @Autowired
    private UseService userService;

   
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userService);

    }

    

    @Override
    public void configure(HttpSecurity http) throws Exception
    {

        http.csrf().disable().authorizeRequests()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/auth").permitAll()
                .antMatchers("/movies").permitAll()
                .antMatchers("/movies/featured?featured=true").permitAll()
                .antMatchers("/tvs/featured?featured=true").permitAll()
                .antMatchers("/movies/{id}").permitAll()
                .antMatchers("/tvs").permitAll()
                .antMatchers("/tvs/{id}").permitAll()
                .antMatchers("/movies/{title}").permitAll()
                .antMatchers("/tvs/{title}").permitAll()
                .anyRequest().authenticated();

    }



   

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {

        return new BCryptPasswordEncoder();
    }


    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


}