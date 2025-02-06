package com.aam.delivery.application.port.out;

import com.aam.delivery.domain.model.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(Long id);
    Optional<Customer>  findByEmail(String mail);
    Customer save(Customer customer);
}
