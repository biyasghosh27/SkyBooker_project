package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.LoginRequest;
import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody LoginRequest loginRequest){
        // return userService.loginUser(user);
        Authentication authentication = authenticationManager.au

    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
