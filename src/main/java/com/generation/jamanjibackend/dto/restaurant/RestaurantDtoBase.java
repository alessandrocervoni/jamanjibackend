package com.generation.jamanjibackend.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RestaurantDtoBase {

    private String name, phone;
    private int openingHour, closingHour;
    private int positionX, positionY;
    private double deliveryPricePerUnit;
    private int maxDeliveryDistance;
    private String imgUrl;
}
