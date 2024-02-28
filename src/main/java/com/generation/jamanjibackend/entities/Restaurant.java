package com.generation.jamanjibackend.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name, phone;
    private int openingHour, closingHour;
    private int positionX, positionY;
    
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "foodTypes", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "food", nullable = false)
    private List<String> foodTypes;
    
    private double deliveryPricePerUnit;
    private int maxDeliveryDistance;
    private String imgUrl;
    
    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")//1-1
    private Menu menu;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    private Set<Delivery> deliveries;

    public String isOpen() {
        LocalDateTime now = LocalDateTime.now();
        int currentHour = now.getHour();
        int currentMinute = now.getMinute();
    
        boolean isOpen;
    
        if (closingHour < openingHour) {
            isOpen = (currentHour > openingHour || (currentHour == openingHour && currentMinute >= 0)) ||
                   (currentHour < closingHour || (currentHour == closingHour && currentMinute < 0));
        } else {
            isOpen = currentHour > openingHour && currentHour < closingHour ||
                   (currentHour == openingHour && currentMinute >= 0) ||
                   (currentHour == closingHour && currentMinute < 0);
        }
    
        return isOpen ? "Aperto" : "Chiuso";
    }

    public double distance () {
        List<Delivery> deliveriesList = new ArrayList<Delivery>(deliveries);
        Delivery d = deliveriesList.get(0);
        double ipotenusa = 0;
        if (d!=null) {
            User u = d.getUser(); //BELLA LI'
            int x1 = u.getPositionX();
            int y1 = u.getPositionY();

            double base = x1-positionX;
            double altezza = y1-positionY;
            ipotenusa = Math.sqrt(Math.pow(base,2)+Math.pow(altezza,2));
            
        } else {
            System.out.println("Non ci sono deliveries, non posso calcolare la distanza!");
        }
        
        return Math.round(ipotenusa * 100);
    } 
}
