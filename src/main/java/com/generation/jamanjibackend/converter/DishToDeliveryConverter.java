package com.generation.jamanjibackend.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.generation.jamanjibackend.dto.dishtodelivery.DishtodeliveryDtoBase;
import com.generation.jamanjibackend.entities.DishToDelivery;

@Service
public class DishToDeliveryConverter {
    
    public Set<DishtodeliveryDtoBase> dtToDtoBase (Set<DishToDelivery> dtSet){

        Set<DishtodeliveryDtoBase> dishes = new HashSet<DishtodeliveryDtoBase>();
        for(DishToDelivery d : dtSet){
            dishes.add(DishtodeliveryDtoBase
            .builder()
            .quantity(d.getQuantity())
            .getPrice(d.getPrice())
            .build());
        }
        return dishes;
    }

}
