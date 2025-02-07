package com.aam.delivery.domain.exception;

public class DeliveryNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DeliveryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeliveryNotFoundException(String message) {
        super(message);
    }
}
