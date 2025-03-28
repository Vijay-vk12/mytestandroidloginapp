package com.userlogin.UserLogin.controller;

import com.userlogin.UserLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register/api")
public class RegisterController {

    @Autowired
    UserService service;

    @PostMapping("/saveRegister")
    public ResponseEntity saveUser(@RequestParam("first_name") String firstName,
                                   @RequestParam("last_name") String lastName,
                                      @RequestParam("email") String email,
                                @RequestParam("password") String password){
      if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
          return new  ResponseEntity<>("Please Fill all the Fields", HttpStatus.BAD_REQUEST);
      }



        String hashPassword= BCrypt.hashpw(password,BCrypt.gensalt());
      int result= service.registerNewUser(firstName,lastName,email,hashPassword);
      if(result!=1){
          return new  ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
      }
        return new  ResponseEntity<>("success", HttpStatus.OK);

    }
}
