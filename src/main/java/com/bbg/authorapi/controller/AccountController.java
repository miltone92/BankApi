package com.bbg.authorapi.controller;


import java.util.List;

import com.bbg.authorapi.model.Account;
import com.bbg.authorapi.service.AccountService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RequestMapping("api/v1/account")
@RestController
public class AccountController{
    AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public void add(@RequestBody Account account) {
        accountService.save(account);
    }

    @GetMapping
    public List<Account> getAll() {
       return accountService.find();

    }
}