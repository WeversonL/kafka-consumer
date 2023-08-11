package br.com.widsl.paymentconsumer.service;

import br.com.widsl.paymentconsumer.domain.dto.PaymentDTO;

public interface PaymentService {

    void processPayment(PaymentDTO paymentDTO);

}
