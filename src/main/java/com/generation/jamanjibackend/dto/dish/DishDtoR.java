package com.generation.jamanjibackend.dto.dish;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;



@Data
@AllArgsConstructor

public class DishDtoR extends DishDtoBase
{   
    //un commento
    public DishDtoR(){}
    private Integer id;
}
