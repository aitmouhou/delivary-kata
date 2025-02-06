package com.aam.delivery.infrastructure.adapters.persistence;

import com.aam.delivery.application.port.in.TrackDeliveryUseCase;
import com.aam.delivery.domain.model.Delivery;
import com.aam.delivery.infrastructure.adapters.persistence.entity.DeliveryEntity;
import com.aam.delivery.infrastructure.adapters.persistence.jpa.DeliveryJpaRepository;
import com.aam.delivery.infrastructure.adapters.persistence.mappers.DeliveryMapper;
import org.springframework.stereotype.Component;

@Component
public class DeliveryRepositoryAdapter implements TrackDeliveryUseCase {

    private final DeliveryJpaRepository jpaRepository;
    private final DeliveryMapper deliveryMapper;

    public DeliveryRepositoryAdapter(DeliveryJpaRepository jpaRepository, DeliveryMapper deliveryMapper) {
        this.jpaRepository = jpaRepository;
        this.deliveryMapper = deliveryMapper;
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        DeliveryEntity delivery = jpaRepository.findById(id).orElseThrow();
        return deliveryMapper.toModel(delivery) ;
    }
}
