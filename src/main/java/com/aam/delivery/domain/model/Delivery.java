package com.aam.delivery.domain.model;

import com.aam.delivery.infrastructure.adapters.persistence.entity.CustomerEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Delivery {
    private Long id;
    private String address;
    private LocalDateTime deliverySlot;
    private DeliveryStatus status;
    private CustomerEntity customer;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliverySlot() {
        return deliverySlot;
    }

    public void setDeliverySlot(LocalDateTime deliverySlot) {
        this.deliverySlot = deliverySlot;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}


