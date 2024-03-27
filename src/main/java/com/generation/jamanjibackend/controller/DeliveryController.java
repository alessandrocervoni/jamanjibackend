package com.generation.jamanjibackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jamanjibackend.converter.DeliveryConverter;
import com.generation.jamanjibackend.dto.delivery.DeliveryDtoWFull;
import com.generation.jamanjibackend.dto.delivery.DeliveryRArrivalNotes;
import com.generation.jamanjibackend.entities.Delivery;
import com.generation.jamanjibackend.repositories.DeliveryRepository;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryRepository dRepo;

    @Autowired
    DeliveryConverter dConv;

    @PutMapping("/delivery/buy/{del_id}")
    public DeliveryDtoWFull buy(@PathVariable Integer del_id,@RequestBody DeliveryRArrivalNotes dto){
        Optional<Delivery> op = dRepo.findById(del_id);
        if (!op.isPresent()) 
        {
            new ResponseEntity<String>("No delivery with id " + del_id, HttpStatus.NOT_FOUND);
        }
     
        Delivery newVersion = dConv.dtoRPut(dto,op.get());

        dRepo.save(newVersion);

        return dConv.deliveryToDtoFull(newVersion);
        
    }


}
