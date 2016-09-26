package com.example.jwt;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;

/**
 * Created by rodrigo on 24/08/16.
 */
public class UserService implements UserDetailsService
{
    private AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    private final HashMap<String, User> userMap = new HashMap<String, User>();

    public final User loadUserByUsername(String username)
    {
        final User user = userMap.get(username);
        if(user == null)
            throw new UsernameNotFoundException("user not found");

        detailsChecker.check(user);
        return user;
    }

    public void addUser(User user)
    {
        userMap.put(user.getUsername(),user);
    }
}
