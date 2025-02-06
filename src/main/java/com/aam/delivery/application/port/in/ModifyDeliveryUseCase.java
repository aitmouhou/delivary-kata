package com.aam.delivery.application.port.in;

import com.aam.delivery.domain.exception.DeliveryNotFoundException;
import com.aam.delivery.domain.model.Delivery;

public interface ModifyDeliveryUseCase {
    Delivery changeDeliveryAddress(Long deliveryId, String newAddress) throws DeliveryNotFoundException;
    Delivery changeDeliverySlot(Long deliveryId, String newSlot) throws DeliveryNotFoundException;
}
