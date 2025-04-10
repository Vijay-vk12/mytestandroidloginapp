package com.userlogin.UserLogin.service;


import com.userlogin.UserLogin.dao.UserRepository;
import com.userlogin.UserLogin.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private com.userlogin.UserLogin.dao.UserRepository repository;

    // Save/Register User
    @Override
    public String saveUser(Users user) {
        repository.save(user);
        return "User registered successfully";
    }

    // Get All Users
    @Override
    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    // Update User by ID
    @Override
    public String updateUser(int id, Users updatedUser) {
        Optional<Users> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhone(updatedUser.getPhone());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setPassword(updatedUser.getPassword());
            repository.save(existingUser);
            return "User updated successfully";
        } else {
            return "User not found with ID: " + id;
        }
    }

    // Delete User by ID
    @Override
    public String deleteUser(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "User deleted successfully";
        } else {
            return "User not found with ID: " + id;
        }
    }

    @Override
    public Optional<Users> getUserById(int id) {
        return  repository.findById(id);
    }
}
