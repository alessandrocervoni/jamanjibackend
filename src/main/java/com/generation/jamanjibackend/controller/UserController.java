package com.generation.jamanjibackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.generation.jamanjibackend.converter.UserConverter;
import com.generation.jamanjibackend.dto.user.UserDtoWFull;
import com.generation.jamanjibackend.dto.user.UserDtoWLogin;
import com.generation.jamanjibackend.entities.User;
import com.generation.jamanjibackend.repositories.UserRepository;

//userlogin
public class UserController 
{
    @Autowired
    UserRepository uRepo;

    @Autowired
    UserConverter uConv;

    @PostMapping("/userlogin")
    public ResponseEntity<?> login(@RequestBody UserDtoWLogin dto){

        Optional<User> op = uRepo.findLogged(dto.getMail(),dto.getPassword());
        if(op.isPresent())
            return new ResponseEntity<UserDtoWFull>(uConv.userDtoWFull(op.get()), HttpStatus.OK);
        else 
            return new ResponseEntity<String>("Credenziali non valide", HttpStatus.UNAUTHORIZED); 

    }
}