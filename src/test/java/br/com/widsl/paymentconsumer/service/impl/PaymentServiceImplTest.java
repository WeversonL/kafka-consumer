package br.com.widsl.paymentconsumer.service.impl;

import br.com.widsl.paymentconsumer.domain.dto.PaymentDTO;
import br.com.widsl.paymentconsumer.domain.entity.PaymentEntity;
import br.com.widsl.paymentconsumer.enums.PaymentMethod;
import br.com.widsl.paymentconsumer.enums.PaymentStatus;
import br.com.widsl.paymentconsumer.exception.PaymentProcessException;
import br.com.widsl.paymentconsumer.repository.PaymentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Test
    @DisplayName("Should throw an exception when the payment id is already registered")
    void processPaymentWhenIdIsAlreadyRegisteredThenThrowException() {
        UUID paymentId = UUID.randomUUID();
        String customerName = "John Doe";
        PaymentMethod paymentMethod = PaymentMethod.CREDIT;
        Double paymentAmount = 100.0;
        PaymentStatus status = PaymentStatus.ANALYSIS;

        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .id(paymentId)
                .customerName(customerName)
                .paymentMethod(paymentMethod)
                .paymentAmount(paymentAmount)
                .status(status)
                .build();

        PaymentEntity existingPayment = new PaymentEntity(paymentId, customerName, paymentMethod, paymentAmount, status);

        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(existingPayment));

        assertThrows(PaymentProcessException.class, () -> paymentService.processPayment(paymentDTO));

        verify(paymentRepository, times(1)).findById(paymentId);
        verifyNoMoreInteractions(paymentRepository);
    }

    @Test
    @DisplayName("Should process the payment when the payment id is not already registered")
    void processPaymentWhenIdIsNotRegistered() {
        UUID paymentId = UUID.randomUUID();
        String customerName = "John Doe";
        PaymentMethod paymentMethod = PaymentMethod.CREDIT;
        Double paymentAmount = 100.0;
        PaymentStatus status = PaymentStatus.PROCESSED;

        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .id(paymentId)
                .customerName(customerName)
                .paymentMethod(paymentMethod)
                .paymentAmount(paymentAmount)
                .status(status)
                .build();

        PaymentEntity entity = modelMapper.map(paymentDTO, PaymentEntity.class);

        when(paymentRepository.findById(paymentDTO.getId())).thenReturn(Optional.empty());
        when(modelMapper.map(paymentDTO, PaymentEntity.class)).thenReturn(entity);

        assertDoesNotThrow(() -> paymentService.processPayment(paymentDTO));

        verify(paymentRepository, times(1)).findById(paymentDTO.getId());
        verify(paymentRepository, times(1)).save(entity);
    }

}