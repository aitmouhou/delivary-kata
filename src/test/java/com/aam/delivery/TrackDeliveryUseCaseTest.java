package com.aam.delivery;

// TrackDeliveryUseCaseTest.java
import com.aam.delivery.application.port.in.TrackDeliveryUseCase;
import com.aam.delivery.application.port.out.DeliveryRepository;
import com.aam.delivery.domain.exception.DeliveryNotFoundException;
import com.aam.delivery.domain.model.Delivery;
import com.aam.delivery.domain.model.DeliveryStatus;
import com.aam.delivery.domain.service.DeliveryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TrackDeliveryUseCaseTest {

    @Mock
    private TrackDeliveryUseCase trackDeliveryUseCase;

    @Mock
    private DeliveryRepository deliveryRepository;

    @BeforeEach
    void setUp() {
        deliveryRepository = mock(DeliveryRepository.class);
        trackDeliveryUseCase = new DeliveryService(deliveryRepository);
    }

    @Test
    void testTrackDelivery() {
        Long deliveryId= 1L;
        Delivery delivery = new Delivery();
        delivery.setId(deliveryId);
        delivery.setStatus(DeliveryStatus.ACCEPTED);

        when(deliveryRepository.findById(deliveryId)).thenReturn(java.util.Optional.of(delivery));
        DeliveryStatus status = trackDeliveryUseCase.getDeliveryById(deliveryId).getStatus();

        assertEquals(DeliveryStatus.ACCEPTED, status);
        verify(deliveryRepository).findById(deliveryId);
    }

    @Test
    void testTrackDeliveryNotFound() {
        Long deliveryId= 1L;
        when(deliveryRepository.findById(deliveryId)).thenReturn(java.util.Optional.empty());

        assertThrows(DeliveryNotFoundException.class, () -> {
            trackDeliveryUseCase.getDeliveryById(deliveryId);
        });
    }
}
