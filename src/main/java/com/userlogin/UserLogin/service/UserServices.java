package com.userlogin.UserLogin.service;


import com.userlogin.UserLogin.models.Users;

import java.util.List;
import java.util.Optional;

public interface UserServices {

    String saveUser(Users user);
    List<Users> getAllUsers();
    String updateUser(int id, Users user);
    String deleteUser(int id);
    Optional<Users> getUserById(int id);
}
