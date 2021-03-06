package com.bbg.bankapi.controller;

import java.util.ArrayList;
import java.util.List;

import com.bbg.bankapi.model.Movement;
import com.bbg.bankapi.service.MovementService;
import com.bbg.bankapi.BankApiApplication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtException;


@CrossOrigin
@RequestMapping("api/v1/movement")
@RestController
public class MovementController{

    MovementService movementService;

    public MovementController(MovementService movementService){
        this.movementService = movementService;
    }

    @PostMapping
    public void add(@RequestBody Movement movement, @RequestHeader String jws) {

        try {
            // Check authorization
            BankApiApplication.jwtConfig.validateKey(jws);
            movementService.save(movement);
        } catch (JwtException e) {
            System.out.println(e);
        }
  
    }

    @GetMapping
    public List<Movement> getAccounts(@RequestParam(value = "destination", defaultValue = "" )String destination, @RequestHeader String jws) {
       
        try {
            // Check authorization
            BankApiApplication.jwtConfig.validateKey(jws);
            if(destination.equals("")){
                //find all accounts
                return movementService.find();
            }else if (!destination.equals("")){
    
                //find account by destination account or origin
                List<Movement> models = new ArrayList<Movement>();
                models = movementService.findByDestination(destination);
                return models;
           }
        } catch (JwtException e) {
            System.out.println(e);
        }

       
       return null;
    }
}