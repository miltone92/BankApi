package com.bbg.authorapi.model;

import com.bbg.authorapi.dto.AccountDto;

public class Account {

    int id;
    int balance;
    String type;
    String accountNumber;
    String IBAN;
    String currency;
    String owner;
    String ownerName;

    public Account(){

    }

    public Account(int balance, String type, String currency, String owner, String accountNumber, String IBAN, String ownerName){
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.currency = currency;
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.IBAN = IBAN;
        this.ownerName = ownerName;
    }

    public Account( AccountDto account){
        this.balance = account.getBalance();
        this.currency = account.getCurrency();
        this.type = account.getType();
        this.currency = account.getCurrency();
        this.owner = account.getOwner();
        this.id = account.getId();
        this.IBAN = account.getIBAN();
        this.accountNumber = account.getAccountNumber();
        this.ownerName = account.getOwnerName();
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    
}