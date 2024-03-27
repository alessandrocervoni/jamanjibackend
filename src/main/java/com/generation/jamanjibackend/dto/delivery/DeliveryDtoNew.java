package com.generation.jamanjibackend.dto.delivery;

import java.util.Set;

import com.generation.jamanjibackend.entities.DishToDelivery;
import com.generation.jamanjibackend.entities.Restaurant;
import com.generation.jamanjibackend.entities.User;

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

public class DeliveryDtoNew extends DeliveryDtoBase{
    private Integer id;
    private Restaurant restaurant;
    private User user;
    private Set<DishToDelivery> dishesDeliveries;
    public double dishesPrices;
    public double riderRevenue;
    public double totalPrice;
    
}
