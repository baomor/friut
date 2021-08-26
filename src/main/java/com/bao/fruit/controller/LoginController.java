package com.bao.fruit.controller;

import com.bao.fruit.entity.User;
import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

    private static final String USERNAME="admin";
    private static final String PASSWORD="123456";


    @GetMapping("/login")
    public User login(User user){
        if (USERNAME.equals(user.getUsername())&&PASSWORD.equals(user.getPassword())){
            user.getToken();
            return user;
        }
        return null;
    }
}
