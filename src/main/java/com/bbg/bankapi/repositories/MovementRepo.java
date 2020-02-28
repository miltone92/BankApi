package com.bbg.bankapi.repositories;

import java.util.List;

import com.bbg.bankapi.dto.MovementDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepo extends JpaRepository<MovementDto, Integer>{
    public List<MovementDto> findByDestinationOrOriginEquals(String destination, String origin);
    public MovementDto findByOrigin(String origin);
}