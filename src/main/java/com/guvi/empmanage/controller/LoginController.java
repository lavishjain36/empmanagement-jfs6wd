package com.guvi.empmanage.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    //handler for route login
    @GetMapping("/login")
    public  String login(){
        return "login";
    }

}
