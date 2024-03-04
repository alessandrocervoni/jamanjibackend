package com.generation.jamanjibackend.dto.delivery;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DeliveryRArrivalNotes {
    private Integer id;
    private LocalDateTime deliveryStartTime;
    private String notes;
    private String paymentMethod;
}
