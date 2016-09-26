package com.example;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by rodrigo on 03/07/16.
 */
@Repository
public class UserRepository
{
    List<CustomUser> users;

    public UserRepository()
    {
        users = new ArrayList<>();
        users.add(new CustomUser("rodrigo","rodrigo007", Arrays.asList(new Role("ROLE_USER"))));
        users.add(new CustomUser("ronaldo","ronaldo007", Arrays.asList(new Role("ROLE_USER"))));
        users.add(new CustomUser("lais","lais007", Arrays.asList(new Role("ROLE_ADMIN"))));
    }

    public Optional<CustomUser> findByUsername(String username)
    {
        return users.stream().
                        filter(u -> u.getUsername().equals(username)).
                        findAny();
    }
}
