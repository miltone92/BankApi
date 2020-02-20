package com.bbg.authorapi.repositories;

import java.util.List;

import com.bbg.authorapi.dto.MovementDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepo extends JpaRepository<MovementDto, Integer>{
    public List<MovementDto> findByDestination(String destination);
    public MovementDto findByOrigin(String origin);
}