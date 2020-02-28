package com.bbg.bankapi.controller;

import com.bbg.bankapi.model.Log;
import com.bbg.bankapi.service.LogService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RequestMapping("api/v1/log")
@RestController
public class LogController{

    LogService logService;

    public LogController(LogService logService){
        this.logService = logService;
    }

    @PostMapping
    public void add(@RequestBody Log log) {
        logService.save(log);
    }

    @GetMapping
    public Log getAccounts(@RequestParam(value = "user", defaultValue = "" )String user) {
       

       return logService.findByUser(user);
    }

}