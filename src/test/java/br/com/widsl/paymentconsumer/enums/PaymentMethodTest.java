package br.com.widsl.paymentconsumer.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("PaymentMethod Test")
class PaymentMethodTest {

    @Test
    void testFromCodeValid() {
        PaymentMethod paymentMethod = PaymentMethod.fromCode("C");
        assertEquals(PaymentMethod.CREDIT, paymentMethod);
    }

    @Test
    void testFromCodeInvalid() {
        PaymentMethod paymentMethod = PaymentMethod.fromCode("X");
        assertNull(paymentMethod);
    }

    @Test
    void testFromCodeUsingMockito() {
        PaymentMethod mockedCredit = mock(PaymentMethod.class);
        when(mockedCredit.getCode()).thenReturn("C");

        PaymentMethod mockedDebit = mock(PaymentMethod.class);
        when(mockedDebit.getCode()).thenReturn("D");

        PaymentMethod actualCredit = PaymentMethod.fromCode(mockedCredit.getCode());
        PaymentMethod actualDebit = PaymentMethod.fromCode(mockedDebit.getCode());

        assertEquals(PaymentMethod.CREDIT, actualCredit);
        assertEquals(PaymentMethod.DEBIT, actualDebit);
    }
}
