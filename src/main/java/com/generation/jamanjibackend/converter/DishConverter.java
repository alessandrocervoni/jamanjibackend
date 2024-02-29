package com.generation.jamanjibackend.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.generation.jamanjibackend.dto.dish.DishDtoCategoryName;
import com.generation.jamanjibackend.entities.Dish;

@Service
public class DishConverter {

    public Set<DishDtoCategoryName> dishDtoCatToDish(Set<Dish> dishSet){

        Set<DishDtoCategoryName> dishCatSet = new HashSet<DishDtoCategoryName>();
        for(Dish d : dishSet){
            
            dishCatSet.add(DishDtoCategoryName
            .builder()
            .id(d.getId())
            .price(d.getPrice())
            .category(d.getCategory())
            .name(d.getName())
            .build());
        }
        return dishCatSet;
    }
}
