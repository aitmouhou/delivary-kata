package com.aam.delivery.infrastructure.adapters.persistence;

import com.aam.delivery.application.port.out.DeliveryRepository;
import com.aam.delivery.domain.model.Delivery;
import com.aam.delivery.infrastructure.adapters.persistence.entity.DeliveryEntity;
import com.aam.delivery.infrastructure.adapters.persistence.jpa.DeliveryJpaRepository;
import com.aam.delivery.infrastructure.adapters.persistence.mappers.DeliveryMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeliveryRepositoryAdapter implements DeliveryRepository {
    private final DeliveryJpaRepository jpaRepository;
    private final DeliveryMapper deliveryMapper;

    public DeliveryRepositoryAdapter(DeliveryJpaRepository jpaRepository, DeliveryMapper deliveryMapper) {
        this.jpaRepository = jpaRepository;
        this.deliveryMapper = deliveryMapper;
    }

    @Override
    public Optional<Delivery> findById(Long id) {
        return jpaRepository.findById(id).map(deliveryMapper::toModel) ;
    }

    @Override
    public Delivery save(Delivery delivery) {
        DeliveryEntity entity = deliveryMapper.toEntity(delivery);
        DeliveryEntity savedEntity = jpaRepository.save(entity);
        return deliveryMapper.toModel(savedEntity);
    }
}
