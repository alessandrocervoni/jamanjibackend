package com.generation.jamanjibackend.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    private boolean isAvailable;

    @JsonIgnore
    @OneToMany(mappedBy = "rider", fetch = FetchType.EAGER)
    private Set<Delivery> deliveries ;
    
    @JsonIgnore
    @OneToMany(mappedBy = "rider", fetch = FetchType.EAGER)
    private Set<Restaurant> restaurants; 

}
