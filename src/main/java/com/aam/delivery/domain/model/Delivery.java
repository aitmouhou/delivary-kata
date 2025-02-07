package com.aam.delivery.domain.model;

import com.aam.delivery.infrastructure.adapters.persistence.entity.CustomerEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class Delivery {
    private Long id;
    private String address;
    private DeliverySlot deliverySlot;
    private DeliveryStatus status;
    private CustomerEntity customer;
}


