package com.generation.jamanjibackend.dto.restaurant;

import java.util.List;

import com.generation.jamanjibackend.entities.Menu;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class RestaurantDtoWFull extends RestaurantDtoBase{

    private Integer id;
    private Menu menu;
    private List<String> foodTypes;
    private String isOpen;

}
