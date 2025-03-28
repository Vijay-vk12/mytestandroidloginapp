package com.userlogin.UserLogin.controller;

import com.userlogin.UserLogin.models.LoginModel;
import com.userlogin.UserLogin.models.User;
import com.userlogin.UserLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login/api")
public class LoginController {


    @Autowired
    UserService service;

    @PostMapping("/userLogin")
    public ResponseEntity authenticateUser(@RequestBody  LoginModel login){

        System.out.println(login.toString());

        List<String> userEmail= service.checkUserEmail(login.getEmail());
        if(userEmail.isEmpty() || userEmail==null){
            return new ResponseEntity("Email does not exist", HttpStatus.NOT_FOUND);
        }
        String hashedPassword= service.checkUserPasswordByEmail(login.getEmail());

        if(!BCrypt.checkpw(login.getPassword(),hashedPassword)){
            return new ResponseEntity("Incorrect User or Password", HttpStatus.BAD_REQUEST);
        }

        User user= service.getUserDetailsByEmail(login.getEmail());
        return new ResponseEntity(user,HttpStatus.OK);

    }
}
