package com.generation.jamanjibackend.entities;


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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Dish 
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String category; 
    private double price;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "ingredients", joinColumns = @JoinColumn(name = "dish_id"))
    @Column(name = "ingredient", nullable = false)
    private List<String> ingredients;

    @JsonIgnore
    @OneToMany(mappedBy = "dish", fetch = FetchType.EAGER)
    private Set<DishToDelivery> deliveries;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;


}

