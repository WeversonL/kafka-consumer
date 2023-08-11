package br.com.widsl.paymentconsumer.repository;

import br.com.widsl.paymentconsumer.domain.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
}
