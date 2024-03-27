package com.generation.jamanjibackend.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.jamanjibackend.dto.menu.MenuDtoDishes;
import com.generation.jamanjibackend.dto.menu.MenuDtoDishesCateg;
import com.generation.jamanjibackend.entities.Menu;

@Service
public class MenuConverter {

    @Autowired
    DishConverter dConv;

    public MenuDtoDishesCateg menuToDtoDishCat (Menu m) {
        
        return  MenuDtoDishesCateg
                .builder()
                .dishes(dConv.dishDtoCatToDish(m.getDishes()))
                .build();
    }

    public MenuDtoDishes menuToDtoDish (Menu m){

        return  MenuDtoDishes
                .builder()
                .dishes(m.getDishes())
                .build();
    }
}
