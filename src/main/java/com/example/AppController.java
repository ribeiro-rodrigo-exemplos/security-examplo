package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by rodrigo on 02/07/16.
 */
@Controller
public class AppController
{
    @Autowired
    private BankService bankService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam(name = "error",required = false)String error)
    {
        //if(error!=null)
            //return "redirect:http://google.com.br";

        return "login";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView home(Principal principal)
    {
        ModelAndView mv = new ModelAndView();
        //CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUser customUser = (CustomUser) ((Authentication) principal).getPrincipal();
        mv.setViewName("home");
        mv.addObject("user",customUser);

        System.out.println("user ---- "+customUser.getUsername());

        return mv;
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String adminPage()
    {
        return "admin";
    }

    @RequestMapping(value = "/contas",method = RequestMethod.GET)
    public String findAccounts()
    {

        bankService.findAccounts();

        return "conta";
    }

    @RequestMapping(value = "/postcontas",method = RequestMethod.GET)
    public String postAccounts()
    {

        bankService.post("conta1",2.2);

        return "conta";
    }


}
