package com.generation.jamanjibackend.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jamanjibackend.converter.DeliveryConverter;
import com.generation.jamanjibackend.dto.delivery.DeliveryDtoNew;
import com.generation.jamanjibackend.entities.Delivery;
import com.generation.jamanjibackend.entities.Dish;
import com.generation.jamanjibackend.entities.DishToDelivery;
import com.generation.jamanjibackend.repositories.DeliveryRepository;
import com.generation.jamanjibackend.repositories.DishRepository;
import com.generation.jamanjibackend.repositories.DishToDeliveryRepository;
import com.generation.jamanjibackend.repositories.RestaurantRepository;
import com.generation.jamanjibackend.repositories.UserRepository;

@RestController
public class DishController {

    @Autowired
    DishRepository dRepo;

    @Autowired
    DeliveryRepository deRepo;

    @Autowired
    DishToDeliveryRepository dtRepo;

    @Autowired 
    UserRepository uRepo;

    @Autowired
    RestaurantRepository rRepo;

    @Autowired
    DeliveryConverter dConv;


    @GetMapping("/createDelivery/{user_id}/{rest_id}")
    public DeliveryDtoNew createDel (@PathVariable Integer user_id, @PathVariable Integer rest_id ) {
        Delivery carrello = new Delivery();
        carrello.setUser(uRepo.findById(user_id).get());
        carrello.setRestaurant(rRepo.findById(rest_id).get());
        deRepo.save(carrello);
        return dConv.deliveryToDtoNew(carrello);
    }
    
    @PutMapping("/dishes/adding/{dish_id}/{del_id}")
    public ResponseEntity<?> accept(@PathVariable Integer dish_id, @PathVariable Integer del_id){
        Optional<Dish> op = dRepo.findById(dish_id);

        if(op.isPresent()){

            Dish d = op.get();
            Set<DishToDelivery> deliveries = d.getDeliveries();
            for (DishToDelivery dt : deliveries){
                dt.setDelivery(deRepo.findById(del_id).get());
                return new ResponseEntity<DishToDelivery>(dtRepo.save(dt),HttpStatus.OK);
            }
            return new ResponseEntity<String>("No delivery with id "+del_id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("No dish with id "+dish_id,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/dishes/deleting/{dish_id}")
    public ResponseEntity<?> delete(@PathVariable Integer dish_id){
        Optional<Dish> op = dRepo.findById(dish_id);

        if(op.isPresent()){

            Dish d = op.get();
            Set<DishToDelivery> deliveries = d.getDeliveries();
            for (DishToDelivery dt : deliveries){
                dtRepo.deleteById(dt.getId());
            }
        }
        return new ResponseEntity<String>("No dish with id "+dish_id,HttpStatus.NOT_FOUND);
    }

}
