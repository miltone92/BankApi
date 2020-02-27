package com.bbg.authorapi.service.implementation;

import com.bbg.authorapi.dto.LogDto;
import com.bbg.authorapi.model.Log;
import com.bbg.authorapi.repositories.LogRepo;
import com.bbg.authorapi.service.LogService;

import org.springframework.stereotype.Service;

@Service
public class LogImp extends LogService {

    private LogRepo logRepo;
    
    public LogImp(LogRepo logRepo){
        this.logRepo = logRepo;
    }

    @Override
    public Log findByUser(String user) {
        return new Log(logRepo.findByUser(user));
    }

    @Override
    public void save(Log log) {
        
        //Find and update previous log

        try{
             Log previousLog = findByUser(log.getUser());
            if(previousLog != null && previousLog.getUser().equalsIgnoreCase(log.getUser())){
                log.setId(previousLog.getId());
                logRepo.save(new LogDto(log));
            }
        }catch(Exception e){
           System.out.println(e.toString());
            logRepo.save(new LogDto(log));
        }
    }

}