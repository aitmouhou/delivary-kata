package com.aam.delivery.application.port.out;

import com.aam.delivery.domain.model.Delivery;

import java.util.Optional;

public interface DeliveryRepository {
    Optional<Delivery> findById(Long id);
    Delivery save(Delivery delivery);
}
