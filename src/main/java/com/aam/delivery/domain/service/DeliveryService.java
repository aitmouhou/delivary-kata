package com.aam.delivery.domain.service;

import com.aam.delivery.application.port.in.ModifyDeliveryUseCase;
import com.aam.delivery.application.port.in.TrackDeliveryUseCase;
import com.aam.delivery.application.port.out.DeliveryRepository;
import com.aam.delivery.domain.exception.DeliveryNotFoundException;
import com.aam.delivery.domain.exception.InvalidDeliveryModificationException;
import com.aam.delivery.domain.model.Delivery;
import com.aam.delivery.domain.model.DeliverySlot;
import com.aam.delivery.domain.model.DeliveryStatus;
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
        if(!delivery.getStatus().equals(DeliveryStatus.READY)) {
            delivery.setAddress(newAddress);
            deliveryRepository.save(delivery);
        }else{
            throw new InvalidDeliveryModificationException("You can not change Address for delivery with status READY");
        }
        return null ;
    }


    @Override
    public Delivery changeDeliverySlot(Long deliveryId, LocalDateTime newSlotStart, LocalDateTime newSlotEnd) {

        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found"));

        if (newSlotStart == null || newSlotEnd == null || newSlotStart.isAfter(newSlotEnd)) {
            throw new IllegalArgumentException("Invalid delivery slot: start time must be before end time");
        }

        if (delivery.getStatus() == DeliveryStatus.READY) {
            throw new IllegalStateException("Cannot change the delivery slot when the delivery is in READY state");
        }

        delivery.setDeliverySlot(new DeliverySlot(newSlotStart, newSlotEnd));

        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found"));
    }
}
