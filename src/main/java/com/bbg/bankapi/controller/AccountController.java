package com.bbg.bankapi.controller;

import java.util.ArrayList;
import java.util.List;

import com.bbg.bankapi.model.Account;
import com.bbg.bankapi.service.AccountService;
import com.bbg.bankapi.BankApiApplication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtException;

import org.springframework.web.bind.annotation.RequestHeader;

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
    public List<Account> getAccounts(@RequestParam(value = "owner", defaultValue = "" )String owner, @RequestParam(value = "number", defaultValue = "" )String number) {
       // @RequestHeader String jws

        try {
            // Check authorization
           // BankApiApplication.jwtConfig.validateKey(jws);
            if(owner.equals("") && number.equals("")){
                //find all accounts
                return accountService.find();
            }else if (!owner.equals("")){
                //find account by owner
                List<Account> models = accountService.findByOwner(owner);
                return models;
           }else if (!number.equals("")){
                //find account by number
                List<Account> models = new ArrayList<Account>();
                Account foundModel = accountService.findByAccountNumber(number);
                models.add(foundModel);
                return models;
           }

        } catch (JwtException e) {
            System.out.println(e);
        }

        return null;


      
    }
}