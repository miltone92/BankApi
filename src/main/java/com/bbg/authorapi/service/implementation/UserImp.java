package com.bbg.authorapi.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.bbg.authorapi.dto.UserDto;
import com.bbg.authorapi.model.User;
import com.bbg.authorapi.repositories.UserRepo;
import com.bbg.authorapi.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserImp extends UserService {

    private UserRepo userRepo;

    public UserImp(UserRepo userRepo){
        this.userRepo= userRepo;
    }

    @Override
    public List<User> find() {
       List<UserDto> userDtos = userRepo.findAll();
       List<User> users = new ArrayList<User>();
       for (UserDto userDto: userDtos){
           users.add(new User(userDto));
       }
        return users;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void save(User user) {
        userRepo.save(new UserDto(user));
    }

    @Override
    public void delete(User user) {
        // TODO Auto-generated method stub

    }




}