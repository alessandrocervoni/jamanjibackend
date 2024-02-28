package com.generation.jamanjibackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jamanjibackend.converter.UserConverter;
import com.generation.jamanjibackend.dto.user.UserDtoWFull;
import com.generation.jamanjibackend.dto.user.UserDtoWLogin;
import com.generation.jamanjibackend.entities.Delivery;
import com.generation.jamanjibackend.entities.User;
import com.generation.jamanjibackend.repositories.DeliveryRepository;
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

    @PostMapping("/userlogin")
    public ResponseEntity<?> login(@RequestBody UserDtoWLogin dto){

        Optional<User> op = uRepo.findByMailAndPassword(dto.getMail(),dto.getPassword());
        if(op.isPresent())
            return new ResponseEntity<UserDtoWFull>(uConv.userDtoWFull(op.get()), HttpStatus.OK);
        else 
            return new ResponseEntity<String>("Credenziali non valide", HttpStatus.UNAUTHORIZED); 

    }

    @GetMapping("/user")
    public void getUser()
    {
       User u = uRepo.findByMailAndPassword("user1@mail.com","password1").get();
        System.out.println(u.getDeliveries());
        System.out.println(u.getMail());
        Delivery d = dRepo.findById(1).get();

    }

}