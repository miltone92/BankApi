package com.bbg.authorapi.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.bbg.authorapi.dto.MovementDto;
import com.bbg.authorapi.model.Movement;
import com.bbg.authorapi.repositories.MovementRepo;
import com.bbg.authorapi.service.MovementService;

import org.springframework.stereotype.Service;

@Service
public class MovementImp extends MovementService{

    private MovementRepo movementRepo;

    public MovementImp(MovementRepo movementRepo){
        this.movementRepo = movementRepo;
    }

    @Override
    public List<Movement> find() {
       List<MovementDto> dtos = movementRepo.findAll();
       List<Movement> models = new ArrayList<Movement>();
        
       for (MovementDto dto : dtos) {
           models.add(new Movement(dto));
       }

       return models;
    }
    
    @Override
    public List<Movement> findByDestination(String destination) {
        List<MovementDto> dtos = movementRepo.findByDestination(destination);
        List<Movement> models = new ArrayList<Movement>();

        for (MovementDto movementDto : dtos) {
            Movement model = new Movement(movementDto);
            models.add(model);
        }
        
        return models;
    }

    @Override
    public Movement findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Movement movement) {
        movementRepo.save(new MovementDto(movement));

    }

    @Override
    public void delete(Movement movement) {
        // TODO Auto-generated method stub

    }


}