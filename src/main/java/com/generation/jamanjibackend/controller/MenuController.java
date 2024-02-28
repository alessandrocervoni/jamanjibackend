package com.generation.jamanjibackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jamanjibackend.converter.MenuConverter;
import com.generation.jamanjibackend.dto.menu.MenuDtoDishesCateg;
import com.generation.jamanjibackend.entities.Menu;
import com.generation.jamanjibackend.entities.Restaurant;
import com.generation.jamanjibackend.repositories.MenuRepository;
import com.generation.jamanjibackend.repositories.RestaurantRepository;

@RestController
public class MenuController {

    @Autowired 
    MenuRepository mRepo;

    @Autowired
    MenuConverter mConv;

    @Autowired
    RestaurantRepository rRepo;
    

    @GetMapping("/menu/{r_id}/dishescat")
    public MenuDtoDishesCateg getMenu(@PathVariable Integer r_id){
        Restaurant r = rRepo.findById(r_id).get();
        int m_id = r.getMenu().getId();

        Menu m = mRepo.findById(m_id).get();
        return mConv.menuToDtoDishCat(m);

    }
}
