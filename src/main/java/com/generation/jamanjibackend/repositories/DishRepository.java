package com.generation.jamanjibackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.jamanjibackend.entities.Dish;



public interface DishRepository extends JpaRepository<Dish,Integer>{

}
