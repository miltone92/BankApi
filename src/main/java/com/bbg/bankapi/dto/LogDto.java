package com.bbg.bankapi.dto;

import com.bbg.bankapi.model.Log;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "log")
public class LogDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String user;
    String os;
    String osVersion;
    String browser;
    String browserVersion;
    String date;


    public LogDto(){

    }

    public LogDto(int id, String user, String os, String osVersion, String browser, String browserVersion, String date) {
        this.id = id;
        this.user = user;
        this.os = os;
        this.osVersion = osVersion;
        this.browser = browser;
        this.browserVersion = browserVersion;
        this.date = date;
    }

    public LogDto(Log log){
        this.id = log.getId();
        this.user = log.getUser();
        this.os = log.getOs();
        this.osVersion = log.getOsVersion();
        this.browser = log.getBrowser();
        this.browserVersion = log.getBrowserVersion();
        this.date = log.getDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
}