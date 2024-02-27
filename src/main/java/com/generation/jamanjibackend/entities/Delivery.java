package com.generation.jamanjibackend.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity

public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate expected_arrival;
    private int distance;
    private String paymentMethod;
    private String notes;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonIgnore
    @OneToMany(mappedBy = "delivery",fetch = FetchType.EAGER)
    private List<DishToDelivery> dishesDeliveries;


    public double getDishesPrices(){
        double res = 0;
        for(DishToDelivery d : dishesDeliveries){
            res += d.getPrice();
        }
        return res;
    }

    public double getRiderRevenue(){
        return restaurant.getDeliveryPricePerUnit()*this.getDistance();
    }

    public double getTotalPrice(){
        return getDishesPrices() + getRiderRevenue();
    }
}
