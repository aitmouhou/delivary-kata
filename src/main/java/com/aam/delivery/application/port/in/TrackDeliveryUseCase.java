package com.aam.delivery.application.port.in;

import com.aam.delivery.domain.model.Delivery;

public interface TrackDeliveryUseCase {
    Delivery getDeliveryById(Long id);
}
