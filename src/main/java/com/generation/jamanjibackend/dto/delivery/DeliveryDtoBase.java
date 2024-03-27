package com.generation.jamanjibackend.dto.delivery;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder


public class DeliveryDtoBase {

    private LocalDateTime expected_arrival;
    private int distance;
    private String paymentMethod;
    private String notes;
}