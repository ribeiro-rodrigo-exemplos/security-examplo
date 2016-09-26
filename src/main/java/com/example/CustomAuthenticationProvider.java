package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Optional;

/**
 * Created by rodrigo on 03/07/16.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider
{
    @Autowired
    private UserRepository repository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {

       String username = authentication.getName();
       String password = (String) authentication.getCredentials();

        System.out.println(username+" "+password);

        Optional<CustomUser> userOptional = repository.findByUsername(username);

        if(userOptional.isPresent())
        {
            CustomUser user = userOptional.get();

            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password))
                return new UsernamePasswordAuthenticationToken(user,password,user.getAuthorities());
            else
                throw new BadCredentialsException("senha ou usuarios invalidos");

        }

       throw new BadCredentialsException("usuário não encontrado");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
