package com.generation.jamanjibackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jamanjibackend.converter.RestaurantConverter;
import com.generation.jamanjibackend.dto.restaurant.RestaurantDtoWFull;
import com.generation.jamanjibackend.dto.restaurant.RestaurantDtoWPitagora;
import com.generation.jamanjibackend.entities.Restaurant;
import com.generation.jamanjibackend.repositories.RestaurantRepository;


@RestController
public class RestaurantController {

    @Autowired
    RestaurantRepository rRepo;

    @Autowired
    RestaurantConverter rConv;

    @GetMapping("/restaurants")
    public List<RestaurantDtoWPitagora> getAllRestPit()
    {
        return  rRepo.findAll()
                .stream()
                .map(r-> rConv.RestToDtoPit(r))
                .toList();
        
    }

    

    @GetMapping("/restaurant/{id}")
    public RestaurantDtoWFull getOneNoPadron(@PathVariable Integer id)
    {
        Optional<Restaurant> op = rRepo.findById(id);

        if(op.isEmpty())
            return null;

        return rConv.RestoToDtoFull(op.get());

    }
   
}
