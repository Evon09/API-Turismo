package br.edu.utfpr.turismoapi.repositories;

import br.edu.utfpr.turismoapi.models.Payment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    
}