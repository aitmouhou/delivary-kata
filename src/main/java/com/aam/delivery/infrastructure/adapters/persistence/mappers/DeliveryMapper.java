package com.aam.delivery.infrastructure.adapters.persistence.mappers;

import com.aam.delivery.domain.model.Delivery;
import com.aam.delivery.infrastructure.adapters.persistence.entity.DeliveryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {
    DeliveryEntity toEntity(Delivery delivery);
    Delivery toModel(DeliveryEntity entity);
}
