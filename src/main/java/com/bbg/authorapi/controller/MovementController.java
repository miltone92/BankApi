package com.bbg.authorapi.controller;

import java.util.ArrayList;
import java.util.List;

import com.bbg.authorapi.model.Movement;
import com.bbg.authorapi.service.MovementService;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RequestMapping("api/v1/movement")
@RestController
public class MovementController{

    MovementService movementService;

    public MovementController(MovementService movementService){
        this.movementService = movementService;
    }

    @PostMapping
    public void add(@RequestBody Movement movement) {
        movementService.save(movement);
    }

    @GetMapping
    public List<Movement> getAccounts(@RequestParam(value = "destination", defaultValue = "" )String destination) {
       
        if(destination.equals("")){
            //find all accounts
            return movementService.find();
        }else if (!destination.equals("")){

            //find account by destination account or origin
            List<Movement> models = new ArrayList<Movement>();
            models = movementService.findByDestination(destination);
            return models;
       }
       return null;
    }
}