package com.aam.delivery.infrastructure.adapters.persistence;

import com.aam.delivery.application.port.out.CustomerRepository;
import com.aam.delivery.domain.model.Customer;
import com.aam.delivery.infrastructure.adapters.persistence.entity.CustomerEntity;
import com.aam.delivery.infrastructure.adapters.persistence.entity.DeliveryEntity;
import com.aam.delivery.infrastructure.adapters.persistence.jpa.CustomerJpaRepository;
import com.aam.delivery.infrastructure.adapters.persistence.mappers.CustomerMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerMapper customerMapper;

    public CustomerRepositoryAdapter(CustomerJpaRepository customerJpaRepository, CustomerMapper customerMapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerJpaRepository.findById(id).map(customerMapper::toModel);
    }

    @Override
    public Optional<Customer> findByEmail(String mail) {
        return  customerJpaRepository.findByEmail(mail).map(customerMapper::toModel);
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = customerMapper.toEntity(customer);
        CustomerEntity savedEntity = customerJpaRepository.save(entity);
        return customerMapper.toModel(savedEntity);
    }
}
