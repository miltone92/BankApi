package com.bbg.bankapi.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.bbg.bankapi.dto.AccountDto;
import com.bbg.bankapi.dto.MovementDto;
import com.bbg.bankapi.model.Movement;
import com.bbg.bankapi.repositories.MovementRepo;
import com.bbg.bankapi.repositories.AccountRepo;
import com.bbg.bankapi.service.MovementService;

import org.springframework.stereotype.Service;

@Service
public class MovementImp extends MovementService{

    private MovementRepo movementRepo;
    private AccountRepo accountRepo;
    
    public MovementImp(MovementRepo movementRepo, AccountRepo accountRepo){
        this.movementRepo = movementRepo;
        this.accountRepo = accountRepo;
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
        List<MovementDto> dtos = movementRepo.findByDestinationOrOriginEquals(destination, destination);
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
        AccountDto origin = accountRepo.findByAccountNumber(movement.getOrigin());
        AccountDto destination = accountRepo.findByAccountNumber(movement.getDestination());
        int amount = movement.getAmount();
      
        if(movement.getType().equalsIgnoreCase("transfer")){
            //update balance
            origin.setBalance(origin.getBalance() - amount);
            destination.setBalance(destination.getBalance() + amount);
            accountRepo.save(destination);
        }else{
            //Case of payments and deposits
            origin.setBalance(origin.getBalance() - amount);
          
        }
            
        accountRepo.save(origin);
        
        
    }

    @Override
    public void delete(Movement movement) {
        // TODO Auto-generated method stub

    }


}