package com.generation.jamanji.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.jamanji.entities.Dish;

public interface DishRepository extends JpaRepository<Dish,Integer>{

}
