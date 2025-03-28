package com.userlogin.UserLogin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api")
public class UserController {


    @GetMapping("/test")
    public String testing(){
        System.out.println("hello word");
        return "Hello World";
    }


}
