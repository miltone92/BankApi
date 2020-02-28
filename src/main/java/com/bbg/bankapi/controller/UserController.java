package com.bbg.bankapi.controller;

import java.util.ArrayList;
import java.util.List;

import com.bbg.bankapi.BankApiApplication;
import com.bbg.bankapi.model.User;
import com.bbg.bankapi.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<User> getUsers(@RequestParam(value = "email", defaultValue = "" )String email, @RequestParam(value = "pw", defaultValue = "")String pw) {
        List<User> models = new ArrayList<User>();


        if(email.equals("") && pw.equals("")){
            //get all users
            return userService.find();
        } else if (!email.equals("") && pw.equals("")){
            //fin by just emai
            User foundModel = userService.findByEmail(email);
            models.add(foundModel);
            return models;

        }else if(!email.equals("") && !pw.equals("")){
            //find by email and pw
            User foundModel = userService.findByEmailAndPw(email, pw);

            if (foundModel.getJwt() == null) {
                foundModel.setJwt(BankApiApplication.jwtConfig.generateKey(foundModel.getUsername()));               
                models.add(foundModel);
                return models;
            }


        }
       
        return null;

    }

}