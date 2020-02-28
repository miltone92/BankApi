package com.bbg.bankapi.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.bbg.bankapi.dto.UserDto;
import com.bbg.bankapi.model.User;
import com.bbg.bankapi.repositories.UserRepo;
import com.bbg.bankapi.service.UserService;

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
   public User findByEmail(String email) {
      UserDto dto = userRepo.findByEmail(email);
      User model = new User(dto);
      return model;
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

    @Override
    public User findByEmailAndPw(String email, String pw) {
        UserDto dto = userRepo.findOneByEmailAndPasswordEquals(email, pw);
        User model = new User(dto);
        return model;
    }




}