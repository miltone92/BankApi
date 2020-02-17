package com.bbg.authorapi.dto;

import com.bbg.authorapi.model.Account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountDto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int balance;
    String type;
    String currency;
    String owner;

    public AccountDto(){

    }

    public AccountDto(int id, int balance, String type, String currency, String owner){
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.currency = currency;
        this.owner = owner;
        this.id = id;
    }

    public AccountDto( Account account){
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

