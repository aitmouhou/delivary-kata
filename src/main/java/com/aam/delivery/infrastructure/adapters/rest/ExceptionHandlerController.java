package com.aam.delivery.infrastructure.adapters.rest;

import com.aam.delivery.domain.exception.DeliveryNotFoundException;
import com.aam.delivery.domain.exception.InvalidDeliveryModificationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(DeliveryNotFoundException.class)
    public ResponseEntity<String> handleNotFound(DeliveryNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(InvalidDeliveryModificationException.class)
    public ResponseEntity<String> handleInvalidModification(InvalidDeliveryModificationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralError(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur interne du serveur");
    }
}
