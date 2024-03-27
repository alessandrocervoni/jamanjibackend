package com.generation.jamanjibackend.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jamanjibackend.converter.DeliveryConverter;
import com.generation.jamanjibackend.converter.DishToDeliveryConverter;
import com.generation.jamanjibackend.dto.delivery.DeliveryDtoNew;
import com.generation.jamanjibackend.dto.delivery.DeliveryDtoWFull;
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

    @Autowired
    DishToDeliveryConverter dtConv;


    @GetMapping("/createDelivery/{user_id}/{rest_id}")
    public DeliveryDtoNew createDel (@PathVariable Integer user_id, @PathVariable Integer rest_id ) {
        Delivery carrello = new Delivery();
        carrello.setUser(uRepo.findById(user_id).get());
        carrello.setRestaurant(rRepo.findById(rest_id).get());
        carrello.getDistance();
        carrello.getDishesDeliveries();
        deRepo.save(carrello);
        return dConv.deliveryToDtoNew(carrello);
    }
    
    @PutMapping("/dishes/adding/{dish_id}/{del_id}")
    public DeliveryDtoWFull accept(@PathVariable Integer dish_id, @PathVariable Integer del_id) {
        Delivery carrello = deRepo.findById(del_id).get();
    
        Optional<Dish> opDish = dRepo.findById(dish_id);
        if (opDish.isPresent()) {
            Dish dish = opDish.get();
            Set<DishToDelivery> ordini = carrello.getDishesDeliveries();
            
            // Cerca se il DishToDelivery esiste già nell'ordine
            boolean found = false;
            for (DishToDelivery dt : ordini) {
                if (dt.getDish().getId().equals(dish.getId())) {
                    int quantity = dt.getQuantity();
                    quantity += 1;
                    dt.setQuantity(quantity);
                    dtRepo.save(dt);
                    found = true;
                    break;
                }
            }
    
            // Se non è stato trovato un DishToDelivery corrispondente, crea uno nuovo
            if (!found) {
                DishToDelivery newOrdine = new DishToDelivery();
                newOrdine.setDish(dish);
                newOrdine.setDelivery(carrello);
                newOrdine.setQuantity(1);
                carrello.getDishesDeliveries().add(newOrdine);
                ordini.add(newOrdine);
                dtRepo.save(newOrdine);
            }
    
        }
        return dConv.deliveryToDtoFull(carrello);
    }


    @DeleteMapping("/dishes/deleting/{dish_id}/{del_id}")
    public DeliveryDtoWFull delete(@PathVariable Integer dish_id, @PathVariable Integer del_id){
        Delivery carrello = deRepo.findById(del_id).get();
        if (carrello == null) {
            new ResponseEntity<String>("No delivery with id " + del_id, HttpStatus.NOT_FOUND);
        }
    
        Optional<Dish> opDish = dRepo.findById(dish_id);
        if (opDish.isPresent()) {
            Dish dish = opDish.get();
            Set<DishToDelivery> ordini = carrello.getDishesDeliveries();
            
            // Cerca se il DishToDelivery esiste già nell'ordine
            boolean found = false;
            for (DishToDelivery dt : ordini) {
                if (dt.getDish().getId().equals(dish.getId())) {
                    int quantity = dt.getQuantity();
                    if(quantity>0){
                        quantity -= 1;
                        dt.setQuantity(quantity);
                        dtRepo.save(dt);
                        found = true;
                    }
                    if(quantity==0){
                        dtRepo.delete(dt);
                        ordini.remove(dt);
                    }
                }
            }
    
            // Se non è stato trovato un DishToDelivery corrispondente
            if (!found) {
                new ResponseEntity<String>("No dishToDelivery with id " + dish_id, HttpStatus.NOT_FOUND);
            }
    
        } else {
            new ResponseEntity<String>("No dish with id " + dish_id, HttpStatus.NOT_FOUND);
        }

        return dConv.deliveryToDtoFull(carrello);
    }


}
