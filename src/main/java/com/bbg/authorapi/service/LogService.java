package com.bbg.authorapi.service;

import com.bbg.authorapi.model.Log;
import org.springframework.stereotype.Service;


@Service
public abstract class LogService{

    public abstract Log  findByUser(String user);
    public abstract void save(Log log);

}