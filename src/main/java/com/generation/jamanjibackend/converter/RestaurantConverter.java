package com.generation.jamanjibackend.converter;

import org.springframework.stereotype.Service;

import com.generation.jamanjibackend.dto.restaurant.RestaurantDtoWFull;
import com.generation.jamanjibackend.dto.restaurant.RestaurantDtoWPitagora;
import com.generation.jamanjibackend.entities.Restaurant;

@Service
public class RestaurantConverter {
    
    public RestaurantDtoWPitagora RestToDtoPit (Restaurant r)
    {
        return  RestaurantDtoWPitagora
                .builder()
                .id(r.getId())
                .name(r.getName())
                .imgUrl(r.getImgUrl())
                .isOpen(r.isOpen())
                .foodTypes(r.getFoodTypes())
                .distance(r.distance())
                .build();
    }

}
