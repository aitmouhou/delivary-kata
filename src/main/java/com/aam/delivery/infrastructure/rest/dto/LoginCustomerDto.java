package com.aam.delivery.infrastructure.rest.dto;

import lombok.Data;

@Data
public class LoginCustomerDto {
    private String email;
    private String password;
}