package com.generation.jamanjibackend.dto.delivery;

import java.util.Set;

import com.generation.jamanjibackend.entities.DishToDelivery;
import com.generation.jamanjibackend.entities.Restaurant;
import com.generation.jamanjibackend.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class DeliveryDtoNew extends DeliveryDtoBase{
    private Restaurant restaurant;
    private User user;
    private Set<DishToDelivery> dishesDeliveries;
    public double getDishesPrices;
    public double getRiderRevenue;
    public double getTotalPrice;
    
}