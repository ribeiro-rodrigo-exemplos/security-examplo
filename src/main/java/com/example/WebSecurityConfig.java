package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Created by rodrigo on 02/07/16.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable().
            authorizeRequests().
                antMatchers("/assets/**","/login**").permitAll().
                antMatchers("/admin").hasRole("ADMIN").
                antMatchers("/**").hasAnyRole("USER","ADMIN").
                anyRequest().authenticated().
                and().
                formLogin().
                loginPage("/login").permitAll().defaultSuccessUrl("/home").
                and().
                logout().
                    logoutUrl("/sair").
                    invalidateHttpSession(true);


                //and().
            //httpBasic();

        /*http.authorizeRequests().
                antMatchers("/admin").hasRole("ADMIN").
                and().
                authorizeRequests().
                antMatchers("/**").hasRole("USER").anyRequest().authenticated().and().httpBasic();*/

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*auth.
            inMemoryAuthentication().
                withUser("roberto").
                    password("roberto007").
                    roles("ADMIN").
                and().
                withUser("rodrigo").
                    password("rodrigo007").
                    roles("USER"); */

        auth.authenticationProvider(authenticationProvider());

    }

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        return new CustomAuthenticationProvider();
    }

}
