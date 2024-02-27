package com.generation.jamanjibackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.generation.jamanjibackend.entities.Delivery.DeliveryBuilder;

public interface DeliveryRepository extends JpaRepository<DeliveryBuilder,Integer>{

}
