package com.aam.delivery.infrastructure.adapters.persistence.mappers;

import com.aam.delivery.domain.model.Delivery;
import com.aam.delivery.infrastructure.adapters.persistence.entity.DeliveryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DeliveryMapper {
    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    DeliveryEntity toEntity(Delivery delivery);
    Delivery toModel(DeliveryEntity entity);
}
