package com.generation.jamanjibackend.dto.dishtodelivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class DishtodeliveryDtoR extends DishtodeliveryDtoBase{

    private Integer id;
}
