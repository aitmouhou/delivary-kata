package com.aam.delivery.infrastructure.rest;

import com.aam.delivery.application.port.in.ModifyDeliveryUseCase;
import com.aam.delivery.application.port.in.TrackDeliveryUseCase;
import com.aam.delivery.domain.exception.DeliveryNotFoundException;
import com.aam.delivery.domain.exception.InvalidDeliveryModificationException;
import com.aam.delivery.domain.model.Delivery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Delivery tracking", description = "Operations related to Delivery tracking")
@RestController
@RequestMapping("/delivery-api/v1")
public class DeliveryController {
    private final ModifyDeliveryUseCase modifyDeliveryUseCase;
    private final TrackDeliveryUseCase trackDeliveryUseCase;

    public DeliveryController(ModifyDeliveryUseCase modifyDeliveryUseCase, TrackDeliveryUseCase trackDeliveryUseCase) {
        this.modifyDeliveryUseCase = modifyDeliveryUseCase;
        this.trackDeliveryUseCase = trackDeliveryUseCase;
    }

    @Operation(summary = "Recherche un document par hashCode")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Un document attaché trouvé"),
                    @ApiResponse(responseCode = "400", description = "Code de recherche invalid"),
                    @ApiResponse(responseCode = "403", description = "Accès non autorisé"),
                    @ApiResponse(responseCode = "404", description = "Aucun document attaché trouvé"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")}
    )
    @PutMapping("/address/{id}")
    public ResponseEntity<Delivery> changeDeliveryAddress(@PathVariable Long id, @RequestBody String deliveryAddress)throws DeliveryNotFoundException {
        Delivery updatedDelivery = modifyDeliveryUseCase.changeDeliveryAddress(id, deliveryAddress);
        return ResponseEntity.ok(updatedDelivery);
    }
    @PutMapping("/slot/{id}")
    public ResponseEntity<Delivery> changeDeliverySlot(@PathVariable Long id, @RequestBody String deliverySlot) throws DeliveryNotFoundException {
        Delivery updatedDelivery = modifyDeliveryUseCase.changeDeliverySlot(id, deliverySlot);
        return ResponseEntity.ok(updatedDelivery);
    }

    @GetMapping("//{id}")
    public ResponseEntity<Delivery> trackDelivery(@PathVariable Long id) throws DeliveryNotFoundException {
        Delivery delivery = trackDeliveryUseCase.getDeliveryById(id);
        return ResponseEntity.ok(delivery);
    }

}
