
package com.generation.jamanjibackend.dto.user;

import java.util.Set;

import com.generation.jamanjibackend.entities.Delivery;

public class UserDtoWFull extends UserDtoBase
{
    private Integer id;
    private Set<Delivery> deliveries;
}

