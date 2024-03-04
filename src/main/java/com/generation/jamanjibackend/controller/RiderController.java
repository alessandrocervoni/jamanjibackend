package com.generation.jamanjibackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jamanjibackend.converter.RiderConverter;
import com.generation.jamanjibackend.dto.rider.RiderDtoName;
import com.generation.jamanjibackend.entities.Delivery;
import com.generation.jamanjibackend.repositories.DeliveryRepository;
import com.generation.jamanjibackend.repositories.RiderRepository;

@RestController
public class RiderController {

    @Autowired
    RiderRepository rRepo;

    @Autowired
    RiderConverter rConv;

    @Autowired
    DeliveryRepository dRepo;
    
    @GetMapping("/rider/{del_id}")
    public RiderDtoName getRider(@RequestParam Integer del_id) {
        Delivery d = dRepo.findById(del_id).get();
        return rConv.riderToDto(d.getRider());
        
    }
}
