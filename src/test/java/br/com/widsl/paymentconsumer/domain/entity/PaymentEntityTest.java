package br.com.widsl.paymentconsumer.domain.entity;

import br.com.widsl.paymentconsumer.enums.PaymentMethod;
import br.com.widsl.paymentconsumer.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PaymentEntity Test")
class PaymentEntityTest {

    private static UUID id;

    @BeforeAll
    static void setup() {
        id = UUID.randomUUID();
    }

    @Test
    @DisplayName("Should return the same hashcode for two equal PaymentEntity objects")
    void hashCodeForEqualPaymentEntityObjects() {
        PaymentEntity paymentEntity1 = new PaymentEntity(id, "John Doe", PaymentMethod.CREDIT, 100.00, PaymentStatus.PROCESSED);

        PaymentEntity paymentEntity2 = new PaymentEntity(id, "John Doe", PaymentMethod.CREDIT, 100.00, PaymentStatus.PROCESSED);

        assertEquals(paymentEntity1.hashCode(), paymentEntity2.hashCode());
    }

    @Test
    @DisplayName("Should return different hashcodes for two non-equal PaymentEntity objects")
    void hashCodeForNonEqualPaymentEntityObjects() {
        PaymentEntity paymentEntity1 = new PaymentEntity(id, "John Doe", PaymentMethod.CREDIT, 100.00, PaymentStatus.PROCESSED);

        PaymentEntity paymentEntity2 = new PaymentEntity(UUID.randomUUID(), "John Doe", PaymentMethod.CREDIT, 200.00, PaymentStatus.PROCESSED);

        assertNotEquals(paymentEntity1.hashCode(), paymentEntity2.hashCode());
    }

    @Test
    @DisplayName("Should return false when compared with different class object")
    void equalsWhenComparedWithDifferentClassObject() {
        PaymentEntity paymentEntity1 = new PaymentEntity(id, "John Doe", PaymentMethod.CREDIT, 100.00, PaymentStatus.PROCESSED);

        Object obj = new Object();

        boolean result = paymentEntity1.equals(obj);

        assertFalse(result);
    }

    @Test
    @DisplayName("Should return false when compared with null")
    void equalsWhenComparedWithNull() {
        PaymentEntity paymentEntity = new PaymentEntity(id, "John Doe", PaymentMethod.CREDIT, 100.00, PaymentStatus.PROCESSED);

        boolean result = paymentEntity.equals(null);

        assertFalse(result);
    }

    @Test
    @DisplayName("Should return true when compared with the same object")
    void equalsWhenComparedWithSameObject() {
        PaymentEntity paymentEntity1 = new PaymentEntity(id, "John Doe", PaymentMethod.CREDIT, 100.00, PaymentStatus.PROCESSED);

        PaymentEntity paymentEntity2 = new PaymentEntity(id, "John Doe", PaymentMethod.CREDIT, 100.00, PaymentStatus.PROCESSED);

        boolean result = paymentEntity1.equals(paymentEntity2);

        assertTrue(result);
    }

    @Test
    @DisplayName("Should return false when compared with same class object having different id")
    void equalsWhenComparedWithSameClassObjectHavingDifferentId() {
        PaymentEntity paymentEntity1 = new PaymentEntity(id, "John Doe", PaymentMethod.CREDIT, 100.00, PaymentStatus.PROCESSED);

        PaymentEntity paymentEntity2 = new PaymentEntity(UUID.randomUUID(), "John Doe", PaymentMethod.DEBIT, 200.00, PaymentStatus.ANALYSIS);

        boolean result = paymentEntity1.equals(paymentEntity2);

        assertFalse(result);
    }

    @Test
    @DisplayName("Should return true when compared with same class object having same id")
    void equalsWhenComparedWithSameClassObjectHavingSameId() {
        PaymentEntity paymentEntity1 = new PaymentEntity(id, "John Doe", PaymentMethod.CREDIT, 100.00, PaymentStatus.PROCESSED);

        PaymentEntity paymentEntity2 = new PaymentEntity(id, "John Doe", PaymentMethod.CREDIT, 100.00, PaymentStatus.PROCESSED);

        assertEquals(paymentEntity1, paymentEntity2);
    }

    @Test
    @DisplayName("Should set the payment status name correctly")
    void testSetPaymentStatus() {
        PaymentEntity paymentEntity = new PaymentEntity();

        paymentEntity.setStatus(PaymentStatus.ANALYSIS);

        assertEquals(PaymentStatus.ANALYSIS, paymentEntity.getStatus());
    }

    @Test
    @DisplayName("Should return the correct payment status when getStatus is called")
    void testGetPaymentStatus() {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setStatus(PaymentStatus.ANALYSIS);

        assertEquals(PaymentStatus.ANALYSIS, paymentEntity.getStatus());
    }

    @Test
    @DisplayName("Should set the payment amount correctly")
    void testSetPaymentAmount() {
        PaymentEntity paymentEntity = new PaymentEntity();

        paymentEntity.setPaymentAmount(600.0);

        assertEquals(600.0, paymentEntity.getPaymentAmount());
    }

    @Test
    @DisplayName("Should return the correct payment amount when getPaymentAmount is called")
    void testGetPaymentAmount() {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentAmount(400.0);

        assertEquals(400.0, paymentEntity.getPaymentAmount());
    }

    @Test
    @DisplayName("Should set the payment method name correctly")
    void testSetPaymentMethod() {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentMethod(PaymentMethod.DEBIT);

        assertEquals(PaymentMethod.DEBIT, paymentEntity.getPaymentMethod());
    }

    @Test
    @DisplayName("Should return the correct payment method when getPaymentMethod is called")
    void testGetPaymentMethod() {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentMethod(PaymentMethod.CREDIT);

        assertEquals(PaymentMethod.CREDIT, paymentEntity.getPaymentMethod());
    }

    @Test
    @DisplayName("Should set the customer name correctly")
    void setCustomerName() {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setCustomerName("Jane Smith");

        assertEquals("Jane Smith", paymentEntity.getCustomerName());
    }

    @Test
    @DisplayName("Should return the correct customer name when getCustomerName is called")
    void getCustomerNameReturnsCorrectName() {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setCustomerName("John Doe");
        String customerName = paymentEntity.getCustomerName();

        assertEquals("John Doe", customerName);
    }

    @Test
    @DisplayName("Should return null when the customer name is not set and getCustomerName is called")
    void getCustomerNameReturnsNullWhenNameNotSet() {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setCustomerName(null);

        assertNull(paymentEntity.getCustomerName());
    }

    @Test
    @DisplayName("Should set the id correctly")
    void setIdCorrectly() {
        PaymentEntity paymentEntity = new PaymentEntity();
        UUID newId = UUID.randomUUID();
        paymentEntity.setId(newId);

        assertEquals(newId, paymentEntity.getId());
    }

    @Test
    @DisplayName("Should return the correct id when getId is called")
    void getIdReturnsCorrectId() {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setId(id);

        assertEquals(id, paymentEntity.getId());
    }

    @Test
    @DisplayName("Should return instance correct of PaymentEntity")
    void testValidationEmptyConstructor() {
        PaymentEntity paymentEntity = new PaymentEntity();
        assertNotNull(paymentEntity);
    }

    @Test
    @DisplayName("Should return instance correct of PaymentEntity with data")
    void testValidation() {
        PaymentEntity paymentEntity = new PaymentEntity(null, "John Doe", PaymentMethod.CREDIT, 100.0, PaymentStatus.ANALYSIS);

        assertEquals("John Doe", paymentEntity.getCustomerName());
        assertEquals(PaymentMethod.CREDIT, paymentEntity.getPaymentMethod());
        assertEquals(100.0, paymentEntity.getPaymentAmount());
        assertEquals(PaymentStatus.ANALYSIS, paymentEntity.getStatus());
    }

}
