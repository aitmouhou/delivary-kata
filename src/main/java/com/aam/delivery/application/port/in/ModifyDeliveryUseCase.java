package com.aam.delivery.application.port.in;

public interface ModifyDeliveryUseCase {
    void changeAddress(Long deliveryId, String newAddress);
    void changeDeliverySlot(Long deliveryId, String newSlot);
}
