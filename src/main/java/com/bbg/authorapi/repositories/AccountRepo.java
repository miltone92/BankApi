package com.bbg.authorapi.repositories;

import com.bbg.authorapi.dto.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;


public interface AccountRepo extends JpaRepository<AccountDto, Integer>{

}