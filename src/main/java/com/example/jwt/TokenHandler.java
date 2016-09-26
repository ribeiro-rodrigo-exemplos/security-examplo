package com.example.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;

/**
 * Created by rodrigo on 24/08/16.
 */
public class TokenHandler
{
    private final String secret;
    private final UserService userService;

    public TokenHandler(String secret,UserService userService)
    {
        this.secret = secret;
        this.userService = userService;
    }

    public User parseUserFromToken(String token)
    {
        String username = Jwts.parser().
                                setSigningKey(secret).
                                parseClaimsJws(token).
                                getBody().
                                getSubject();

        return userService.loadUserByUsername(username);
    }

    public String createTokenForUser(User user)
    {
        return Jwts.builder().
                        setSubject(user.getUsername()).
                        signWith(SignatureAlgorithm.ES512,secret).
                        compact();
    }

}
