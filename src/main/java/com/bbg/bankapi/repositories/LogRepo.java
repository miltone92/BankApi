package com.bbg.bankapi.repositories;



import com.bbg.bankapi.dto.LogDto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LogRepo extends JpaRepository<LogDto, Integer>{
    public LogDto findByUser(String user);

}