package com.generation.jamanjibackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.jamanjibackend.entities.Restaurant;



public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{

}
