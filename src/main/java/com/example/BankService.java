package com.example;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rodrigo on 03/07/16.
 */
@Service
public class BankService
{
    public String readAccount(Long id)
    {
        return "conta1";
    }

    @Secured("ROLE_USER")
    public List<String> findAccounts()
    {
        return Arrays.asList("conta1","conta2");
    }

    @Secured("ROLE_ADMIN")
    public String post(String account,double amount)
    {
        return "conta1";
    }
}
