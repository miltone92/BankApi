package com.bbg.bankapi.model;

import java.util.Date;

import com.bbg.bankapi.dto.MovementDto;

public class Movement {

    int id;
    String name;
    String date;
    String type;
    String detail;
    String origin;
    String destination;
    int amount;
    String currency;

    public Movement(){

    }

    public Movement(int id, String name, String date, String type, String detail, String origin, String destination, int amount, String currency){
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = type;
        this.detail = detail;
        this.origin = origin;
        this.destination = destination;
        this.amount = amount;
        this.currency = currency;
    }

    
    public Movement(MovementDto dto){
        this.id = dto.getId();
        this.name = dto.getName();
        this.date =  dto.getDate();
        this.type = dto.getType();
        this.detail = dto.getDetail();
        this.origin = dto.getOrigin();
        this.destination = dto.getDestination();
        this.amount = dto.getAmount();
        this.currency = dto.getCurrency();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    
    

}