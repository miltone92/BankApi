package com.bbg.authorapi.model;

import com.bbg.authorapi.dto.AccountDto;

public class Account {

    int id;
    int balance;
    String type;
    String currency;
    String owner;

    public Account(){

    }

    public Account(int id, int balance, String type, String currency, String owner){
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.currency = currency;
        this.owner = owner;
        this.id = id;
    }

    public Account( AccountDto account){
        this.balance = account.getBalance();
        this.currency = account.getCurrency();
        this.type = account.getType();
        this.currency = account.getCurrency();
        this.owner = account.getOwner();
        this.id = account.getId();
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    
}