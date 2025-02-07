package com.aam.delivery.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class DeliverySlot {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
