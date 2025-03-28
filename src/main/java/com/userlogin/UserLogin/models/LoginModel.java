package com.userlogin.UserLogin.models;

public class LoginModel {


    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public LoginModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
