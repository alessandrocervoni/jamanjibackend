package com.generation.jamanjibackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jamanjibackend.converter.RiderConverter;
import com.generation.jamanjibackend.dto.rider.RiderDtoName;
import com.generation.jamanjibackend.entities.Restaurant;
import com.generation.jamanjibackend.entities.Rider;
import com.generation.jamanjibackend.repositories.RestaurantRepository;
import com.generation.jamanjibackend.repositories.RiderRepository;

@RestController
public class RiderController {

    @Autowired
    RiderRepository rRepo;

    @Autowired
    RiderConverter rConv;

    @Autowired
    RestaurantRepository resRepo;
    
    @GetMapping("/riders/{rest_id}")
    public List<RiderDtoName> getRider(@PathVariable Integer rest_id) {
        Restaurant r = resRepo.findById(rest_id).get();
        List<RiderDtoName> allRiders = new ArrayList<RiderDtoName>();
        for(Rider rider : r.getRiders()){
            allRiders.add(rConv.riderToDto(rider));
        }
        return allRiders;
        
    }
}
