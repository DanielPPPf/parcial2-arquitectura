package co.edu.unisabana.parcial.controller.dto;

import co.edu.unisabana.parcial.controller.dto.CheckpointDTO;
import co.edu.unisabana.parcial.service.CheckpointService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GateControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CheckpointService checkpointService;  // Mock del servicio que utiliza el controlador

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCheckinSuccess() throws Exception {
        // Crear un DTO de ejemplo para la solicitud
        CheckpointDTO checkpoint = new CheckpointDTO("Facility A", "Driver B", 15);

        // Simular el comportamiento del servicio
        doNothing().when(checkpointService).checkin(checkpoint);

        // Convertir el DTO a JSON usando ObjectMapper
        String checkpointJson = objectMapper.writeValueAsString(checkpoint);

        // Realizar una solicitud POST simulada al controlador
        mockMvc.perform(post("/checkpoint/checkin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(checkpointJson))
                .andExpect(status().isOk())  // Verificar que la respuesta sea 200 OK
                .andExpect(MockMvcResultMatchers.jsonPath("$.transactionResult").value(true));  // Verificar que el resultado sea true
    }

    @Test
    void testCheckinFailure() throws Exception {
        // Crear un DTO de ejemplo para la solicitud
        CheckpointDTO checkpoint = new CheckpointDTO("Facility A", "Driver B", 15);

        // Simular una excepción en el servicio
        doNothing().doThrow(new RuntimeException()).when(checkpointService).checkin(checkpoint);

        // Convertir el DTO a JSON usando ObjectMapper
        String checkpointJson = objectMapper.writeValueAsString(checkpoint);

        // Realizar una solicitud POST simulada al controlador
        mockMvc.perform(post("/checkpoint/checkin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(checkpointJson))
                .andExpect(status().isOk())  // Verificar que la respuesta sea 200 OK
                .andExpect(MockMvcResultMatchers.jsonPath("$.transactionResult").value(false));  // Verificar que el resultado sea false
    }
}
