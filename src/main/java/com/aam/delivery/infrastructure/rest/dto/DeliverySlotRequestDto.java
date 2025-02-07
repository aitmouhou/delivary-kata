package com.aam.delivery.infrastructure.rest.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliverySlotRequestDto {
    private LocalDateTime slotStart;
    private LocalDateTime slotEnd;
}
