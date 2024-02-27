package com.generation.jamanji.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.jamanji.entities.User;

public interface UserRepository extends JpaRepository <User,Integer>{

}
