package com.bbg.bankapi.repositories;

import java.util.List;

import com.bbg.bankapi.dto.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepo extends JpaRepository<AccountDto, Integer>{
    public List<AccountDto> findByOwner(String owner);
    public AccountDto findByAccountNumber(String number);
}