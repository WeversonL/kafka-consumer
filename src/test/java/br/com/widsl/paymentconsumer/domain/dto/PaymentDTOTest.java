package br.com.widsl.paymentconsumer.domain.dto;

import br.com.widsl.paymentconsumer.enums.PaymentMethod;
import br.com.widsl.paymentconsumer.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PaymentDTO Test")
class PaymentDTOTest {

    private static UUID id;

    @BeforeAll
    static void setup() {
        id = UUID.randomUUID();
    }

    @Test
    @DisplayName("Should correctly convert PaymentDTO object to string")
    void toStringCorrectlyConvertsPaymentDTO() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .id(id)
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .status(PaymentStatus.ANALYSIS)
                .build();

        String expectedString = "PaymentDTO{" +
                "id=" + id +
                ", customerName='John Doe'" +
                ", paymentMethod=CREDIT" +
                ", paymentAmount=100.0" +
                ", status=ANALYSIS" +
                "}";

        assertEquals(expectedString, paymentDTO.toString());
    }

    @Test
    @DisplayName("Should return the same hashcode for two equal PaymentDTO objects")
    void hashCodeForEqualPaymentDTOObjects() {
        PaymentDTO paymentDTO1 = new PaymentDTO.Builder()
                .id(id)
                .customerName("John Doe")
                .paymentMethod(
                        PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        PaymentDTO paymentDTO2 = new PaymentDTO.Builder()
                .id(id)
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        assertEquals(paymentDTO1.hashCode(), paymentDTO2.hashCode());
    }

    @Test
    @DisplayName("Should return different hashcodes for two non-equal PaymentDTO objects")
    void hashCodeForNonEqualPaymentDTOObjects() {
        PaymentDTO paymentDTO1 = new PaymentDTO.Builder()
                .id(id)
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        PaymentDTO paymentDTO2 = new PaymentDTO.Builder()
                .id(UUID.randomUUID())
                .customerName("Jane Smith")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(200.0)
                .build();

        assertNotEquals(paymentDTO1.hashCode(), paymentDTO2.hashCode());
    }

    @Test
    @DisplayName("Should return false when compared with different class object")
    void equalsWhenComparedWithDifferentClassObject() {
        PaymentDTO paymentDTO1 = new PaymentDTO.Builder()
                .id(id)
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        Object obj = new Object();

        boolean result = paymentDTO1.equals(obj);

        assertFalse(result);
    }

    @Test
    @DisplayName("Should return false when compared with null")
    void equalsWhenComparedWithNull() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .id(id)
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        boolean result = paymentDTO.equals(null);

        assertFalse(result);
    }

    @Test
    @DisplayName("Should return true when compared with the same object")
    void equalsWhenComparedWithSameObject() {
        PaymentDTO paymentDTO1 = new PaymentDTO.Builder()
                .id(id)
                .customerName("John Doe")
                .paymentMethod(
                        PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        PaymentDTO paymentDTO2 = new PaymentDTO.Builder()
                .id(id)
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        boolean result = paymentDTO1.equals(paymentDTO2);

        assertTrue(result);
    }

    @Test
    @DisplayName("Should return false when compared with same class object having different id")
    void equalsWhenComparedWithSameClassObjectHavingDifferentId() {
        PaymentDTO paymentDTO1 = new PaymentDTO.Builder()
                .id(id)
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        PaymentDTO paymentDTO2 = new PaymentDTO.Builder()
                .id(UUID.randomUUID())
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        boolean result = paymentDTO1.equals(paymentDTO2);

        assertFalse(result);
    }

    @Test
    @DisplayName("Should return true when compared with same class object having same id")
    void equalsWhenComparedWithSameClassObjectHavingSameId() {
        PaymentDTO paymentDTO1 = new PaymentDTO.Builder()
                .id(id)
                .customerName("John Doe")
                .paymentMethod(
                        PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        PaymentDTO paymentDTO2 = new PaymentDTO.Builder()
                .id(id)
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        assertEquals(paymentDTO1, paymentDTO2);
    }

    @Test
    @DisplayName("Should set the payment status name correctly")
    void testSetPaymentStatus() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .status(null)
                .build();

        paymentDTO.setStatus(PaymentStatus.ANALYSIS);

        assertEquals(PaymentStatus.ANALYSIS, paymentDTO.getStatus());
    }

    @Test
    @DisplayName("Should return the correct payment status when getStatus is called")
    void testGetPaymentStatus() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .status(PaymentStatus.ANALYSIS)
                .build();

        assertEquals(PaymentStatus.ANALYSIS, paymentDTO.getStatus());
    }

    @Test
    @DisplayName("Should set the payment amount correctly")
    void testSetPaymentAmount() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(500.0)
                .build();

        paymentDTO.setPaymentAmount(600.0);

        assertEquals(600.0, paymentDTO.getPaymentAmount());
    }

    @Test
    @DisplayName("Should return the correct payment amount when getPaymentAmount is called")
    void testGetPaymentAmount() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .customerName("John Doe")
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(400.0)
                .build();

        assertEquals(400.0, paymentDTO.getPaymentAmount());
    }

    @Test
    @DisplayName("Should set the payment method name correctly")
    void testSetPaymentMethod() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .paymentMethod(PaymentMethod.CREDIT)
                .build();

        paymentDTO.setPaymentMethod(PaymentMethod.DEBIT);

        assertEquals(PaymentMethod.DEBIT, paymentDTO.getPaymentMethod());
    }

    @Test
    @DisplayName("Should return the correct payment method when getPaymentMethod is called")
    void testGetPaymentMethod() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .paymentMethod(PaymentMethod.DEBIT)
                .build();

        assertEquals(PaymentMethod.DEBIT, paymentDTO.getPaymentMethod());
    }

    @Test
    @DisplayName("Should set the customer name correctly")
    void setCustomerName() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .customerName("John Doe")
                .build();

        paymentDTO.setCustomerName("Jane Smith");

        assertEquals("Jane Smith", paymentDTO.getCustomerName());
    }

    @Test
    @DisplayName("Should return the correct customer name when getCustomerName is called")
    void getCustomerNameReturnsCorrectName() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .customerName("John Doe")
                .build();

        String customerName = paymentDTO.getCustomerName();

        assertEquals("John Doe", customerName);
    }

    @Test
    @DisplayName("Should return null when the customer name is not set and getCustomerName is called")
    void getCustomerNameReturnsNullWhenNameNotSet() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .id(id)
                .paymentMethod(PaymentMethod.CREDIT)
                .paymentAmount(100.0)
                .build();

        paymentDTO.setCustomerName(null);

        assertNull(paymentDTO.getCustomerName());
    }

    @Test
    @DisplayName("Should set the id correctly")
    void setIdCorrectly() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .id(id)
                .build();

        UUID newId = UUID.randomUUID();
        paymentDTO.setId(newId);

        assertEquals(newId, paymentDTO.getId());
    }

    @Test
    @DisplayName("Should return the correct id when getId is called")
    void getIdReturnsCorrectId() {
        PaymentDTO paymentDTO = new PaymentDTO.Builder()
                .id(id)
                .build();

        assertEquals(id, paymentDTO.getId());
    }

    @Test
    @DisplayName("Should return instance correct of PaymentDTO")
    void testValidationEmptyConstructor() {
        PaymentDTO paymentDTO = new PaymentDTO();
        assertNotNull(paymentDTO);
    }

    @Test
    @DisplayName("Should return instance correct of PaymentDTO with data")
    void testValidation() {
        PaymentDTO paymentDTO = new PaymentDTO(null, "John Doe", PaymentMethod.CREDIT, 100.0, PaymentStatus.ANALYSIS);

        assertEquals("John Doe", paymentDTO.getCustomerName());
        assertEquals(PaymentMethod.CREDIT, paymentDTO.getPaymentMethod());
        assertEquals(100.0, paymentDTO.getPaymentAmount());
        assertEquals(PaymentStatus.ANALYSIS, paymentDTO.getStatus());
    }

}

@DisplayName("PaymentDTOBuilder Test")
class PaymentDTOBuildTest {

    @Test
    @DisplayName("Should return a PaymentDTO with all fields correctly set when build is called")
    void buildWithAllFieldsSetCorrectly() {
        UUID id = UUID.randomUUID();
        String customerName = "John Doe";
        PaymentMethod paymentMethod = PaymentMethod.CREDIT;
        Double paymentAmount = 100.0;

        PaymentDTO.Builder builder = new PaymentDTO.Builder();
        builder.id(id)
                .customerName(customerName)
                .paymentMethod(paymentMethod)
                .paymentAmount(paymentAmount);

        PaymentDTO paymentDTO = builder.build();

        assertNotNull(paymentDTO.getId());
        assertEquals(id, paymentDTO.getId());
        assertEquals(customerName, paymentDTO.getCustomerName());
        assertEquals(paymentMethod, paymentDTO.getPaymentMethod());
        assertEquals(paymentAmount, paymentDTO.getPaymentAmount());
    }

    @Test
    @DisplayName("Should return a PaymentDTO with the correct payment method when build is called")
    void buildWithCorrectPaymentMethod() {
        UUID id = UUID.randomUUID();
        String customerName = "John Doe";
        PaymentMethod paymentMethod = PaymentMethod.CREDIT;
        Double paymentAmount = 100.0;

        PaymentDTO.Builder builder = new PaymentDTO.Builder()
                .id(id)
                .customerName(customerName)
                .paymentMethod(paymentMethod)
                .paymentAmount(paymentAmount);

        PaymentDTO paymentDTO = builder.build();

        assertEquals(id, paymentDTO.getId());
        assertEquals(customerName, paymentDTO.getCustomerName());
        assertEquals(paymentMethod, paymentDTO.getPaymentMethod());
        assertEquals(paymentAmount, paymentDTO.getPaymentAmount());
    }

    @Test
    @DisplayName("Should set the id correctly in the PaymentDTO")
    void IdSetsCorrectly() {
        UUID id = UUID.randomUUID();
        PaymentDTO.Builder builder = new PaymentDTO.Builder();

        PaymentDTO paymentDTO = builder.id(id).build();

        assertEquals(id, paymentDTO.getId());
    }

    @Test
    @DisplayName("Should set the customer name correctly in the PaymentDTO")
    void CustomerNameSetsCorrectly() {
        String customerName = "John Doe";
        PaymentDTO.Builder builder = new PaymentDTO.Builder();

        PaymentDTO paymentDTO = builder.customerName(customerName).build();

        assertEquals(customerName, paymentDTO.getCustomerName());
    }

    @Test
    @DisplayName("Should set the payment method correctly in the PaymentDTO")
    void PaymentMethodSetsCorrectly() {
        PaymentMethod paymentMethod = PaymentMethod.DEBIT;
        PaymentDTO.Builder builder = new PaymentDTO.Builder();

        PaymentDTO paymentDTO = builder.paymentMethod(paymentMethod).build();

        assertEquals(paymentMethod, paymentDTO.getPaymentMethod());
    }

    @Test
    @DisplayName("Should set the payment amount correctly in the PaymentDTO")
    void PaymentAmountSetsCorrectly() {
        Double paymentAmount = 10.0;
        PaymentDTO.Builder builder = new PaymentDTO.Builder();

        PaymentDTO paymentDTO = builder.paymentAmount(paymentAmount).build();

        assertEquals(paymentAmount, paymentDTO.getPaymentAmount());
    }

}