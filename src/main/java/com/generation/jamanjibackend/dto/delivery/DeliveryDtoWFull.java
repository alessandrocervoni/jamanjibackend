package com.generation.jamanjibackend.dto.delivery;

import java.util.List;

import com.generation.jamanjibackend.entities.DishToDelivery;
import com.generation.jamanjibackend.entities.Restaurant;
import com.generation.jamanjibackend.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeliveryDtoWFull extends DeliveryDtoBase{

    private Integer id;
    private User user;
    private Restaurant restaurant;
    private List<DishToDelivery> dishesDeliveries;
    public double getDishesPrices;
    public double getRiderRevenue;
    public double getTotalPrice;

}
