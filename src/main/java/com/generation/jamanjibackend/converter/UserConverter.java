package com.generation.jamanjibackend.converter;

import org.springframework.stereotype.Service;

import com.generation.jamanjibackend.dto.user.UserDtoBase;
import com.generation.jamanjibackend.dto.user.UserDtoWFull;
import com.generation.jamanjibackend.entities.User;

@Service
public class UserConverter {

    public UserDtoWFull userDtoWFull(User u)
    {
        return UserDtoWFull
                .builder()
                .id(u.getId())
                .mail(u.getMail())
                .password(u.getPassword())
                .positionX(u.getPositionX())
                .positionY(u.getPositionY())
                .deliveries(u.getDeliveries())
                .build();
    }

    public User dtoBaseToUser(UserDtoBase dto) {
        
        return  User
                .builder()
                .mail(dto.getMail())
                .password(dto.getPassword())
                .positionX(dto.getPositionX())
                .positionY(dto.getPositionY())
                .build();
    }

}
