package br.com.widsl.paymentconsumer.domain.dto;

import br.com.widsl.paymentconsumer.enums.PaymentMethod;
import br.com.widsl.paymentconsumer.enums.PaymentStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class PaymentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6439365909495382853L;

    private UUID id;
    private String customerName;
    private PaymentMethod paymentMethod;
    private Double paymentAmount;
    private PaymentStatus status;

    public PaymentDTO() {

    }

    public PaymentDTO(UUID id, String customerName, PaymentMethod paymentMethod, Double paymentAmount, PaymentStatus status) {
        this.id = id;
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PaymentDTO that = (PaymentDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", paymentMethod=" + paymentMethod +
                ", paymentAmount=" + paymentAmount +
                ", status=" + status +
                '}';
    }

    public static class Builder {

        private final PaymentDTO paymentDTO;

        public Builder() {
            paymentDTO = new PaymentDTO();
        }

        public Builder id(UUID id) {
            paymentDTO.id = id;
            return this;
        }

        public Builder customerName(String customerName) {
            paymentDTO.customerName = customerName;
            return this;
        }

        public Builder paymentMethod(PaymentMethod paymentMethod) {
            paymentDTO.paymentMethod = paymentMethod;
            return this;
        }

        public Builder paymentAmount(Double paymentAmount) {
            paymentDTO.paymentAmount = paymentAmount;
            return this;
        }

        public Builder status(PaymentStatus paymentStatus) {
            paymentDTO.status = paymentStatus;
            return this;
        }

        public PaymentDTO build() {
            return paymentDTO;
        }
    }

}
