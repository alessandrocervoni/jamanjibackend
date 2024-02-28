package com.generation.jamanjibackend.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.generation.jamanjibackend.dto.dish.DishDtoCategory;
import com.generation.jamanjibackend.entities.Dish;

@Service
public class DishConverter {

    public Set<DishDtoCategory> dishDtoCatToDish(Set<Dish> dishSet){

        Set<DishDtoCategory> dishCatSet = new HashSet<DishDtoCategory>();
        for(Dish d : dishSet){
            
            dishCatSet.add(DishDtoCategory
            .builder()
            .category(d.getCategory())
            .build());
        }
        return dishCatSet;
    }
}
