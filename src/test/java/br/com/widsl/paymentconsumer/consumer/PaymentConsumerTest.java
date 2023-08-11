package br.com.widsl.paymentconsumer.consumer;

import br.com.widsl.paymentconsumer.domain.dto.PaymentDTO;
import br.com.widsl.paymentconsumer.enums.PaymentMethod;
import br.com.widsl.paymentconsumer.enums.PaymentStatus;
import br.com.widsl.paymentconsumer.exception.PaymentProcessException;
import br.com.widsl.paymentconsumer.service.impl.PaymentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentConsumerTest {

    @Mock
    private PaymentServiceImpl paymentService;

    @Mock
    private ObjectMapper mapper;

    @InjectMocks
    private PaymentConsumer paymentConsumer;

    @BeforeEach
    void setup() {
        paymentConsumer = new PaymentConsumer(paymentService, mapper);
    }

    @Test
    @DisplayName("Should custom exception when the message is not valid")
    void consumeWhenMessageIsNotValidThenLogErrorAndThrowException() throws JsonProcessingException {
        String invalidMessage = "Invalid message";

        when(mapper.readValue(invalidMessage, PaymentDTO.class)).thenThrow(JsonProcessingException.class);

        assertThrows(PaymentProcessException.class, () -> paymentConsumer.consume(invalidMessage));

    }

    @Test
    @DisplayName("Should process the payment when the message is valid")
    void consumeWhenMessageIsValid() throws JsonProcessingException {
        String validMessage = "{\"id\":\"d4e8e3a2-6e4a-4e4b-9e4c-6e4d8e4f8a9b\",\"customerName\":\"John Doe\",\"paymentMethod\":\"CREDIT\",\"paymentAmount\":100.0,\"status\":\"ANALYSIS\"}";

        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .id(UUID.fromString("d4e8e3a2-6e4a-4e4b-9e4c-6e4d8e4f8a9b"))
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .status(PaymentStatus.ANALYSIS)
                .build();

        when(mapper.readValue(validMessage, PaymentDTO.class)).thenReturn(paymentDTO);

        paymentConsumer.consume(validMessage);

        verify(paymentService).processPayment(paymentDTO);


    }

}