package com.generation.jamanjibackend.converter;

import com.generation.jamanjibackend.dto.user.UserDtoWFull;
import com.generation.jamanjibackend.entities.User;

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
}
