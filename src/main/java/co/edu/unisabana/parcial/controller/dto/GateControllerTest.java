package co.edu.unisabana.parcial.controller.dto;
import co.edu.unisabana.parcial.controller.GateController;
import co.edu.unisabana.parcial.service.CheckpointService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

class GateControllerTest {

    @Mock
    private CheckpointService checkpointService;

    @InjectMocks
    private GateController gateController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCheckinSuccess() {
        CheckpointDTO checkpoint = new CheckpointDTO();
        ResponseGate expectedResponse = new ResponseGate(true);


        ResponseGate response = gateController.checkin(checkpoint);

        assertEquals(expectedResponse.isTransactionResult(), response.isTransactionResult());
        verify(checkpointService).checkin(checkpoint);
    }

    @Test
    void testCheckinException() {
        CheckpointDTO checkpoint = new CheckpointDTO();
        doThrow(new RuntimeException()).when(checkpointService).checkin(any(CheckpointDTO.class));

        // Act
        ResponseGate response = gateController.checkin(checkpoint);

        // Assert
        assertFalse(response.isTransactionResult());
        verify(checkpointService).checkin(any(CheckpointDTO.class));
    }
}

