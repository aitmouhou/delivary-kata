package com.aam.delivery.infrastructure.adapters.rest;

import com.aam.delivery.application.port.in.ModifyDeliveryUseCase;
import com.aam.delivery.application.port.in.TrackDeliveryUseCase;
import com.aam.delivery.domain.exception.DeliveryNotFoundException;
import com.aam.delivery.domain.exception.InvalidDeliveryModificationException;
import com.aam.delivery.domain.model.Delivery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery-api/v1")
public class DeliveryController {
    private final ModifyDeliveryUseCase modifyDeliveryUseCase;
    private final TrackDeliveryUseCase trackDeliveryUseCase;

    public DeliveryController(ModifyDeliveryUseCase modifyDeliveryUseCase, TrackDeliveryUseCase trackDeliveryUseCase) {
        this.modifyDeliveryUseCase = modifyDeliveryUseCase;
        this.trackDeliveryUseCase = trackDeliveryUseCase;
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<Delivery> changeDeliveryAddress(@PathVariable Long id, @RequestBody String deliveryAddress)throws DeliveryNotFoundException {
        Delivery updatedDelivery = modifyDeliveryUseCase.changeDeliveryAddress(id, deliveryAddress);
        return ResponseEntity.ok(updatedDelivery);
    }
    @PutMapping("/slot/{id}")
    public ResponseEntity<Delivery> changeDeliverySlot(@PathVariable Long id, @RequestBody String deliverySlot) throws DeliveryNotFoundException {
        Delivery updatedDelivery = modifyDeliveryUseCase.changeDeliverySlot(id, deliverySlot);
        return ResponseEntity.ok(updatedDelivery);
    }

    @GetMapping("//{id}")
    public ResponseEntity<Delivery> trackDelivery(@PathVariable Long id) throws DeliveryNotFoundException {
        Delivery delivery = trackDeliveryUseCase.getDeliveryById(id);
        return ResponseEntity.ok(delivery);
    }

}
