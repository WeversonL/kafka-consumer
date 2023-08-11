package br.com.widsl.paymentconsumer.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("PaymentStatus Test")
class PaymentStatusTest {

    @Test
    void testPaymentStatusEnum() {
        PaymentStatus paymentStatus = PaymentStatus.valueOf("ANALYSIS");

        assertEquals("ANALYSIS", paymentStatus.name());

        assertEquals("ANALYSIS", paymentStatus.toString());

        assertEquals(PaymentStatus.valueOf("ANALYSIS"), paymentStatus);

        assertEquals(0, paymentStatus.ordinal());
    }
}
