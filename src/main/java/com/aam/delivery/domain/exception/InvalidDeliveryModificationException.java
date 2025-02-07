package com.aam.delivery.domain.exception;

public class InvalidDeliveryModificationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalidDeliveryModificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDeliveryModificationException(String message) {
        super(message);
    }
}
