package com.generation.jamanjibackend.dto.restaurant;
    //(solo nome, immagine, se APERTO, foodTypes e DISTANZA)

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RestaurantDtoWPitagora {
    
    private String name;
    private String imgUrl;
    private boolean isOpen;
    private List<String> foodTypes;
    private double distance;

}
