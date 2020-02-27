package com.bbg.authorapi.model;

import com.bbg.authorapi.dto.LogDto;

public class Log {

    int id;
    String user;
    String os;
    String osVersion;
    String browser;
    String browserVersion;
    String date;


    public Log(){

    }

    public Log(int id, String user, String os, String osVersion, String browser, String browserVersion, String date) {
        this.id = id;
        this.user = user;
        this.os = os;
        this.osVersion = osVersion;
        this.browser = browser;
        this.browserVersion = browserVersion;
        this.date = date;
    }

    public Log(LogDto dto){
        this.id = dto.getId();
        this.user = dto.getUser();
        this.os = dto.getOs();
        this.osVersion = dto.getOsVersion();
        this.browser = dto.getBrowser();
        this.browserVersion = dto.getBrowserVersion();
        this.date = dto.getDate();
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