package com.bbg.authorapi.repositories;



import com.bbg.authorapi.dto.LogDto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LogRepo extends JpaRepository<LogDto, Integer>{
    public LogDto findByUser(String user);

}