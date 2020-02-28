package com.bbg.bankapi.service;

import java.util.List;

import com.bbg.bankapi.model.Account;
import org.springframework.stereotype.Service;


@Service
public abstract class AccountService {
    public abstract List <Account> find();
    public abstract Account findById(int id);
    public abstract List<Account> findByOwner(String owner);
    public abstract Account findByAccountNumber(String number);
    public abstract void save(Account account);
    public abstract void delete(Account account);
}