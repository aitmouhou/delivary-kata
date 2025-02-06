package com.aam.delivery.infrastructure.adapters.persistence.jpa;

import com.aam.delivery.application.port.out.DeliveryRepository;
import com.aam.delivery.domain.model.Delivery;
import com.aam.delivery.infrastructure.adapters.persistence.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryJpaRepository extends JpaRepository<DeliveryEntity, Long> {
}
