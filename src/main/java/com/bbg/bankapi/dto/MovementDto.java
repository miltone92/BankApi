package com.bbg.bankapi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bbg.bankapi.model.Movement;

@Entity
@Table(name = "movement")
public class MovementDto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String date;
    String type;
    String detail;
    String origin;
    String destination;
    int amount;
    String currency;
    
    public MovementDto(){

    }

    public MovementDto(int id, String name, String date, String type, String detail, String origin, String destination, int amount, String currency){
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = type;
        this.detail = detail;
        this.origin = origin;
        this.destination = destination;
        this.currency = currency;
    }

    public MovementDto(Movement model){
        this.id = model.getId();
        this.name = model.getName();
        this.date =  model.getDate();
        this.type = model.getType();
        this.detail = model.getDetail();
        this.origin = model.getOrigin();
        this.destination = model.getDestination();
        this.amount = model.getAmount();
        this.currency = model.getCurrency();
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