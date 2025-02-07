package com.aam.delivery.infrastructure.rest.dto;

import jakarta.websocket.server.ServerEndpoint;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegisterCustomerDto {
    private String username;
    private String firstname;
    private String email;
    private String password;
}
