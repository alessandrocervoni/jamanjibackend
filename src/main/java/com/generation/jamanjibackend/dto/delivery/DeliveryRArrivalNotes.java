package com.generation.jamanjibackend.dto.delivery;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeliveryRArrivalNotes {
    private Integer id;
    private LocalDateTime expected_arrival;
    private String notes;
}
