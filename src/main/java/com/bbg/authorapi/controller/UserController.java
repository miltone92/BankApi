package com.bbg.authorapi.controller;

import java.util.List;

import com.bbg.authorapi.model.User;
import com.bbg.authorapi.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("api/v1/user")
@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
       return userService.find();

    }

}