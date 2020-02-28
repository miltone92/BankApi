package com.bbg.bankapi.service;

import com.bbg.bankapi.model.Log;
import org.springframework.stereotype.Service;


@Service
public abstract class LogService{

    public abstract Log  findByUser(String user);
    public abstract void save(Log log);

}