package com.generation.jamanjibackend.converter;

import org.springframework.stereotype.Service;

import com.generation.jamanjibackend.dto.rider.RiderDtoName;
import com.generation.jamanjibackend.entities.Rider;

@Service
public class RiderConverter {

    public RiderDtoName riderToDto(Rider r){
        return  RiderDtoName
                .builder()
                .id(r.getId())
                .name(r.getName())
                .isAvailable(r.isAvailable())
                .build();
    }
}
