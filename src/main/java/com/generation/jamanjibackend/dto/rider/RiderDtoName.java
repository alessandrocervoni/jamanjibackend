package com.generation.jamanjibackend.dto.rider;

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
}
