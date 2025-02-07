package com.aam.delivery.infrastructure.adapters.persistence.entity;

import com.aam.delivery.domain.model.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "deliveries")
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerEntity customer;

    @Embedded
    private DeliverySlotEntity deliverySlot;
}
