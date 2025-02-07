package com.aam.delivery.application.port.in;

import com.aam.delivery.domain.exception.DeliveryNotFoundException;
import com.aam.delivery.domain.exception.InvalidDeliveryModificationException;
import com.aam.delivery.domain.model.Delivery;

import java.time.LocalDateTime;

public interface ModifyDeliveryUseCase {
    Delivery changeDeliveryAddress(Long deliveryId, String newAddress) throws InvalidDeliveryModificationException;
    Delivery changeDeliverySlot(Long deliveryId, LocalDateTime newSlotStart, LocalDateTime newSlotEnd) throws InvalidDeliveryModificationException;
}
