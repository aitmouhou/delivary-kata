package com.aam.delivery.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliverySlot {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public DeliverySlot(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }


}
