package com.bbg.authorapi.service;

import java.util.List;

import com.bbg.authorapi.model.Account;

import org.springframework.stereotype.Service;


@Service
public abstract class AccountService {
    public abstract List <Account> find();
    public abstract Account findById(int id);
    public abstract void save(Account account);
    public abstract void delete(Account account);
}