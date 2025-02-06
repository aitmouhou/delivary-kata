package com.aam.delivery.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Delivery {
    private Long id;
    private String address;
    private LocalDateTime deliverySlot;
    private DeliveryStatus status;

}


