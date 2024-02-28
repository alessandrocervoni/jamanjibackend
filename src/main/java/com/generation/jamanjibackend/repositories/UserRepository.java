package com.generation.jamanjibackend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.generation.jamanjibackend.entities.User;



public interface UserRepository extends JpaRepository <User,Integer>{

    @Query(value="SELECT * FROM user WHERE mail= :mail AND password= :password",nativeQuery=true)
    Optional<User> findLogged (@Param ("mail")String mail, @Param ("password")String password);
}
