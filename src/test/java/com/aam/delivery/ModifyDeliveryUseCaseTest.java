package com.aam.delivery;

// ModifyDeliveryUseCaseTest.java
import com.aam.delivery.application.port.in.ModifyDeliveryUseCase;
import com.aam.delivery.application.port.out.DeliveryRepository;
import com.aam.delivery.domain.exception.InvalidDeliveryModificationException;
import com.aam.delivery.domain.model.Delivery;
import com.aam.delivery.domain.model.DeliveryStatus;
import com.aam.delivery.domain.service.DeliveryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ModifyDeliveryUseCaseTest {

    private ModifyDeliveryUseCase modifyDeliveryUseCase;
    private DeliveryRepository deliveryRepository;

    @BeforeEach
    void setUp() {
        deliveryRepository = mock(DeliveryRepository.class);
        modifyDeliveryUseCase = new DeliveryService(deliveryRepository);
    }

    @Test
    void testModifyDeliveryAddress() {

        Long deliveryId= 1L;
        String newAddress = "1 first street 98764 second city any country   ";
        Delivery delivery = new Delivery();
        delivery.setStatus(DeliveryStatus.ACCEPTED);
        delivery.setId(deliveryId);
        when(deliveryRepository.findById(deliveryId)).thenReturn(java.util.Optional.of(delivery));

        modifyDeliveryUseCase.changeDeliveryAddress(deliveryId, newAddress);

        verify(deliveryRepository).save(delivery);
        assertEquals(newAddress, delivery.getAddress());
    }

    @Test
    void testModifyDeliveryAddressWhenStateIsReady() {

        Long deliveryId= 1L;
        String newAddress = "1 first street 98764 second city any country   ";
        Delivery delivery = new Delivery();
        delivery.setId(deliveryId);
        delivery.setStatus(DeliveryStatus.READY);
        when(deliveryRepository.findById(deliveryId)).thenReturn(java.util.Optional.of(delivery));

        assertThrows(InvalidDeliveryModificationException.class, () -> {
            modifyDeliveryUseCase.changeDeliveryAddress(deliveryId, newAddress);
        });
    }
}
