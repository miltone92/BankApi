package com.bbg.authorapi.service;

import java.util.List;

import com.bbg.authorapi.model.User;

import org.springframework.stereotype.Service;

@Service
public abstract class UserService {
    public abstract List <User> find();
    public abstract User findByEmail(String email);
    public abstract User findByEmailAndPw(String email, String pw);
    public abstract User findById(int id);
    public abstract void save(User user);
    public abstract void delete(User user);
}