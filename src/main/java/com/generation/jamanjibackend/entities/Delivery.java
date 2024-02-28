package com.generation.jamanjibackend.entities;

import java.time.LocalDate;
import java.util.Set;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@ToString


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
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "delivery",fetch = FetchType.EAGER)
    private Set<DishToDelivery> dishesDeliveries;


    public double getDishesPrices(){
        double res = 0;
        for(DishToDelivery d : dishesDeliveries){
            res += d.getPrice()*d.getQuantity();
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
