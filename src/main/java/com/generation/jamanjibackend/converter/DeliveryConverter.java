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
                .getDishesPrices(d.getDishesPrices())
                .getRiderRevenue(d.getRiderRevenue())
                .getTotalPrice(d.getTotalPrice())
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
                .getDishesPrices(d.getDishesPrices())
                .getRiderRevenue(d.getRiderRevenue())
                .getTotalPrice(d.getTotalPrice())
                .build();
    }

    public Delivery dtoRPut (DeliveryRArrivalNotes dto, Delivery oldVersion){
        if(dto.getExpected_arrival()!=null && dto.getNotes()!=null){
            oldVersion.setExpected_arrival(dto.getExpected_arrival());
            oldVersion.setNotes(dto.getNotes());
        }
        if(dto.getPaymentMethod()!=null){
            oldVersion.setPaymentMethod(dto.getPaymentMethod());
        }
       return oldVersion;
    }
}
