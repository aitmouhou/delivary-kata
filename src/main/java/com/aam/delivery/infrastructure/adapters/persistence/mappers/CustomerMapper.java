package com.aam.delivery.infrastructure.adapters.persistence.mappers;

import com.aam.delivery.domain.model.Customer;
import com.aam.delivery.infrastructure.adapters.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {DeliveryMapper.class})
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer toModel(CustomerEntity entity);
    CustomerEntity toEntity(Customer customer);


}
