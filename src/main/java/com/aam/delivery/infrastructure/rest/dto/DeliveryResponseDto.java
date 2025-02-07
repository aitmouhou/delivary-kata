package com.aam.delivery.infrastructure.rest.dto;

import com.aam.delivery.domain.model.Delivery;
import com.aam.delivery.domain.model.DeliverySlot;
import com.aam.delivery.domain.model.DeliveryStatus;
import lombok.Data;

@Data
public class DeliveryResponseDto {

    private Long id;
    private String customerId;
    private String address;
    private DeliveryStatus state;
    private DeliverySlot deliverySlot;

    // map DeliveryResponseDto from  Delivery model
    public DeliveryResponseDto(Delivery delivery) {
        this.id = delivery.getId();
        this.customerId = String.valueOf(delivery.getCustomer().getCustomerId());
        this.address = delivery.getAddress();
        this.state = delivery.getStatus();
        this.deliverySlot = delivery.getDeliverySlot();
    }
}
