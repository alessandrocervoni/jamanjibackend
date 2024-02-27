package com.generation.jamanjibackend.dto.dish;

import java.util.Set;

import com.generation.jamanjibackend.entities.DishToDelivery;
import com.generation.jamanjibackend.entities.Menu;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class DishDtoWFull extends DishDtoBase
{
    private Integer id;
    private Set<DishToDelivery> deliveries;
    private Menu menu;

}
