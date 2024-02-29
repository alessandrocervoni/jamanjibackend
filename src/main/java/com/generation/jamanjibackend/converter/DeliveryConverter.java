package com.generation.jamanjibackend.converter;

import org.springframework.stereotype.Service;

import com.generation.jamanjibackend.dto.delivery.DeliveryDtoNew;
import com.generation.jamanjibackend.entities.Delivery;

@Service
public class DeliveryConverter {
    public DeliveryDtoNew deliveryToDtoNew (Delivery d){

        return  DeliveryDtoNew
                .builder()
                .id(d.getId())
                .expected_arrival(d.getExpected_arrival())
                .distance(d.getDistance())
                .paymentMethod(d.getPaymentMethod())
                .notes(d.getNotes())
                .user(d.getUser())
                .restaurant(d.getRestaurant())
                .dishesDeliveries(d.getDishesDeliveries())
                .getDishesPrices(d.getDishesPrices())
                .getRiderRevenue(d.getRiderRevenue())
                .getTotalPrice(d.getTotalPrice())
                .build();
    }
}
