package com.generation.jamanjibackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jamanjibackend.converter.UserConverter;
import com.generation.jamanjibackend.dto.user.UserDtoBase;
import com.generation.jamanjibackend.dto.user.UserDtoWFull;
import com.generation.jamanjibackend.dto.user.UserDtoWLogin;
import com.generation.jamanjibackend.entities.User;
import com.generation.jamanjibackend.repositories.DeliveryRepository;
import com.generation.jamanjibackend.repositories.RestaurantRepository;
import com.generation.jamanjibackend.repositories.UserRepository;

@RestController
public class UserController 
{
    @Autowired
    UserRepository uRepo;

    @Autowired
    UserConverter uConv;

    @Autowired
    DeliveryRepository dRepo;

    @Autowired
    RestaurantRepository rRepo;

    @PostMapping("/userlogin")
    public ResponseEntity<?> login(@RequestBody UserDtoWLogin dto){

        Optional<User> op = uRepo.findByMailAndPassword(dto.getMail(),dto.getPassword());
        if(op.isPresent())
            return new ResponseEntity<UserDtoWFull>(uConv.userDtoWFull(op.get()), HttpStatus.OK);
        else 
            return new ResponseEntity<String>("Credenziali non valide", HttpStatus.UNAUTHORIZED); 

    }

    @PostMapping("user/register")
    public void addUser(@RequestBody UserDtoBase dto){

        User u = uConv.dtoBaseToUser(dto);
        uRepo.save(u);
    }


}