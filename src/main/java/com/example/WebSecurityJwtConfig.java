package com.example;

import com.example.jwt.TokenAuthenticationService;
import com.example.jwt.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by rodrigo on 23/08/16.
 */
//@Configuration
//@EnableWebSecurity
public class WebSecurityJwtConfig extends WebSecurityConfigurerAdapter
{
    private UserService userService;
    private TokenAuthenticationService tokenAuthenticationService;

    public WebSecurityJwtConfig()
    {
        this.userService = new UserService();
        this.tokenAuthenticationService = new TokenAuthenticationService("tooManySecrets",userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }
}
