package com.generation.jamanjibackend.dto.restaurant;

import java.util.List;

import com.generation.jamanjibackend.entities.Menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class RestaurantDtoWFull extends RestaurantDtoBase{

    private Integer id;
    private Menu menu;
    private List<String> foodTypes;
    private String isOpen;

}
