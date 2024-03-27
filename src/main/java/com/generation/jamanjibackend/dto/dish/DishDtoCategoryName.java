package com.generation.jamanjibackend.dto.dish;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DishDtoCategoryName {
    private Integer id;
    private double price;
    private String category;
    private String name;
}
