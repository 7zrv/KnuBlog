package com.example.knublog.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserViewController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String singup(){
        return "signup";
    }
}
