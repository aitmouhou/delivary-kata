package com.aam.delivery.domain.service;

import com.aam.delivery.application.port.in.ModifyDeliveryUseCase;
import com.aam.delivery.application.port.in.TrackDeliveryUseCase;
import com.aam.delivery.application.port.out.DeliveryRepository;
import com.aam.delivery.domain.exception.DeliveryNotFoundException;
import com.aam.delivery.domain.model.Delivery;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeliveryService implements ModifyDeliveryUseCase, TrackDeliveryUseCase {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Delivery changeDeliveryAddress(Long deliveryId, String newAddress) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found"));
        delivery.setAddress(newAddress);
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery changeDeliverySlot(Long deliveryId, String newSlot) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found"));
        delivery.setDeliverySlot(LocalDateTime.parse(newSlot));
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found"));
    }
}
