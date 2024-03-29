package com.generation.jamanjibackend.dto.dishtodelivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DishtodeliveryDtoBase {

    private int quantity;
    private double getPrice;
}