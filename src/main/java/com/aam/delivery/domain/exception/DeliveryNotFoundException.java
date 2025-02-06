package com.aam.delivery.domain.exception;

public class DeliveryNotFoundException extends RuntimeException {
    public DeliveryNotFoundException(String msg) {
        super(msg);
    }
}
