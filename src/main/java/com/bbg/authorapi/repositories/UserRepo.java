package com.bbg.authorapi.repositories;

import com.bbg.authorapi.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDto, Integer> {

    public UserDto findByEmail(String email);
    public UserDto findOneByEmailAndPasswordEquals(String email, String pw);
}
