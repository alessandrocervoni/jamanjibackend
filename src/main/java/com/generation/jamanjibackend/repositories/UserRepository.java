package com.generation.jamanjibackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.jamanjibackend.entities.User;



public interface UserRepository extends JpaRepository <User,Integer>{

}
