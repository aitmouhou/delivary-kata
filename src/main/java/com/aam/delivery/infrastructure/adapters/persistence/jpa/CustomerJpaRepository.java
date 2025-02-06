package com.aam.delivery.infrastructure.adapters.persistence.jpa;

import com.aam.delivery.domain.model.Customer;
import com.aam.delivery.infrastructure.adapters.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
     Optional<CustomerEntity> findByEmail(String mail);
}
