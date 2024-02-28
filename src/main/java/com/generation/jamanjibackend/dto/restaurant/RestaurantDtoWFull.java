package com.generation.jamanjibackend.dto.restaurant;

import java.util.List;

import com.generation.jamanjibackend.entities.Menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RestaurantDtoWFull extends RestaurantDtoBase{

    private Menu menu;
    private List<String> foodTypes;

}
