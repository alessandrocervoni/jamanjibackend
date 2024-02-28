package com.generation.jamanjibackend.dto.menu;

import java.util.Set;

import com.generation.jamanjibackend.dto.dish.DishDtoCategoryName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MenuDtoDishesCateg {
    private Set<DishDtoCategoryName> dishes;
}
