package com.bbg.bankapi.service;

import java.util.List;

import com.bbg.bankapi.model.Movement;
import org.springframework.stereotype.Service;

@Service
public abstract class MovementService{
    public abstract List <Movement> find();
    public abstract Movement findById(int id);
    public abstract List<Movement>  findByDestination(String destination);
    public abstract void save(Movement movement);
    public abstract void delete(Movement movement);
}