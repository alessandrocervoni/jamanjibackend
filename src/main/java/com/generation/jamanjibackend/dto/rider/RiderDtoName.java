package com.generation.jamanjibackend.dto.rider;

import java.util.Set;

import com.generation.jamanjibackend.entities.Delivery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RiderDtoName {
    private Integer id;
    private String name;
    private boolean isAvailable;
    private Set<Delivery> deliveries;
}
