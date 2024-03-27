package com.generation.jamanjibackend.dto.dishtodelivery;

import com.generation.jamanjibackend.entities.Delivery;
import com.generation.jamanjibackend.entities.Dish;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishtodeliveryDtoWFull {

    private Integer id;
    private Dish dish;
    private Delivery delivery;
    public double getPrice;
}
