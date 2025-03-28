package com.userlogin.UserLogin.service;

import com.userlogin.UserLogin.dao.UserRepo;
import com.userlogin.UserLogin.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepo repo;

    public int registerNewUser(String fName, String lName, String email, String password){
        LocalDateTime currentDate=LocalDateTime.now();
        return repo.registerNewUser(fName,lName,email,password,currentDate);
    }


    public List<String> checkUserEmail(String email){
        return repo.checkUserEmail(email);
    }

    public String checkUserPasswordByEmail(String email){
        return repo.checkUserPasswordByEmail(email);
    }

    public User getUserDetailsByEmail(String email){
        return repo.getAllDetailsByUserEmail(email);
    }
}
