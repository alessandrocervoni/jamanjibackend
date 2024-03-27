package com.generation.jamanjibackend.dto.restaurant;
    //(solo nome, immagine, se APERTO, foodTypes e DISTANZA)

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class RestaurantDtoWPitagora extends RestaurantDtoBase{
    
    private int id;
    private String name;
    private String imgUrl;
    private String isOpen;
    private List<String> foodTypes;

}
