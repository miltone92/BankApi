package com.bbg.authorapi.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.bbg.authorapi.dto.AccountDto;
import com.bbg.authorapi.model.Account;
import com.bbg.authorapi.repositories.AccountRepo;
import com.bbg.authorapi.service.AccountService;

import org.springframework.stereotype.Service;

@Service
public class AccountImp extends AccountService{

    private AccountRepo accountRepo;

    public AccountImp(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    @Override
    public List<Account> find() {
       List<AccountDto> dtos = accountRepo.findAll();
       List<Account> models = new ArrayList<Account>();
        for (AccountDto dto : dtos) {
            models.add(new Account(dto));
        }
        return models;
    }

    @Override
    public Account findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Account account) {
        accountRepo.save(new AccountDto(account));
    }

    @Override
    public void delete(Account account) {
       

    }

    @Override
    public List<Account> findByOwner(String owner) {
      List<AccountDto> dtos = accountRepo.findByOwner(owner);
      List<Account> models = new ArrayList<Account>();

      for (AccountDto dto : dtos) {
        Account model = new Account(dto);
        models.add(model);
    }

    return models;



    }

    @Override
    public Account findByAccountNumber(String number) {
        System.out.println(number);  
        AccountDto dto = accountRepo.findByAccountNumber(number);
        Account model = new Account(dto);
        return model;
    }

}