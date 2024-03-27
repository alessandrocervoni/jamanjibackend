
package com.generation.jamanjibackend.dto.user;

import java.util.Set;

import com.generation.jamanjibackend.entities.Delivery;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class UserDtoWFull extends UserDtoBase
{
    private Integer id;
    private Set<Delivery> deliveries;
}

