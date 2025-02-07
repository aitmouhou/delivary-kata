package com.aam.delivery.infrastructure.exception;

import com.aam.delivery.domain.exception.DeliveryNotFoundException;
import com.aam.delivery.domain.exception.InvalidDeliveryModificationException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DeliveryNotFoundException.class)
    public ResponseEntity<String> handleNotFound(DeliveryNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(InvalidDeliveryModificationException.class)
    public ResponseEntity<String> handleInvalidModification(InvalidDeliveryModificationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
