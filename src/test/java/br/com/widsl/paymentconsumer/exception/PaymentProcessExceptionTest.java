package br.com.widsl.paymentconsumer.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("PaymentProcessException Test")
class PaymentProcessExceptionTest {

    @Test
    @DisplayName("Validate that the PaymentProcessException exception is being instantiated correctly")
    void testPaymentProcessException() {
        PaymentProcessException exception = new PaymentProcessException("message");
        assertEquals("message", exception.getMessage());
        assertTrue(exception instanceof PaymentProcessException);
    }

}