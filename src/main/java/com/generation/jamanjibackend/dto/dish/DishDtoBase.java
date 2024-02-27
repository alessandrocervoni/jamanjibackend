package com.generation.jamanjibackend.dto.dish;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class DishDtoBase 
{
    private String name;
    private String category; 
    private double price;
}

