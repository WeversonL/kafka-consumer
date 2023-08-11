package br.com.widsl.paymentconsumer.exception;

public class PaymentProcessException extends RuntimeException {
    public PaymentProcessException(String message) {
        super(message);
    }
}
