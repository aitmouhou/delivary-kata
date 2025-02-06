package com.aam.delivery.infrastructure.adapters.persistence.entity;

import com.aam.delivery.domain.model.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "DELIVERY")
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private LocalDateTime deliverySlot;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;
}
