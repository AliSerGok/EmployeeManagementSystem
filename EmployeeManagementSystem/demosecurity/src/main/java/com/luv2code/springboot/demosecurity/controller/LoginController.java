package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoggingPage")
    public String showLeadersPage(){

        return "fancy-login";
    }

    @GetMapping("/showAuthorizedRegistrationPage")
    public String showAuthorizedRegistrationPage(){

        return "registration";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){

        return "access-denied";
    }


}
