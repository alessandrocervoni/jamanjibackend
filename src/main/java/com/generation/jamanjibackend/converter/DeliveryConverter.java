package com.generation.jamanjibackend.converter;

import org.springframework.stereotype.Service;

import com.generation.jamanjibackend.dto.delivery.DeliveryDtoNew;
import com.generation.jamanjibackend.dto.delivery.DeliveryDtoWFull;
import com.generation.jamanjibackend.dto.delivery.DeliveryRArrivalNotes;
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
                .dishesPrices(d.getDishesPrices())
                .riderRevenue(d.getRiderRevenue())
                .totalPrice(d.getTotalPrice())
                .build();
    }

    public DeliveryDtoWFull deliveryToDtoFull (Delivery d){

        return  DeliveryDtoWFull
                .builder() 
                .id(d.getId())
                .expected_arrival(d.getExpected_arrival())
                .distance(d.getDistance())
                .paymentMethod(d.getPaymentMethod())
                .notes(d.getNotes())
                .user(d.getUser())
                .restaurant(d.getRestaurant())
                .dishesDeliveries(d.getDishesDeliveries())
                .dishesPrices(d.getDishesPrices())
                .riderRevenue(d.getRiderRevenue())
                .totalPrice(d.getTotalPrice())
                .build();
    }

    public Delivery dtoRPut (DeliveryRArrivalNotes dto, Delivery oldVersion){
        oldVersion.setExpected_arrival(dto.getExpected_arrival());
        oldVersion.setNotes(dto.getNotes());
        oldVersion.setPaymentMethod(dto.getPaymentMethod());
        return oldVersion;
    }
}
