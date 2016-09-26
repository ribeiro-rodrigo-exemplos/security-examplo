package com.example;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by rodrigo on 03/07/16.
 */
public class Role implements GrantedAuthority
{
    private String name;

    public Role(String name)
    {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
