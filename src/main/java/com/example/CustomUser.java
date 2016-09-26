package com.example;

import java.util.List;

/**
 * Created by rodrigo on 03/07/16.
 */
public class CustomUser
{
    private String username;
    private String password;
    private String email;
    private List<Role> authorities;

    public CustomUser(String username,String password,List<Role> authorities)
    {
        setUsername(username);
        setPassword(password);
        setAuthorities(authorities);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }
}
