package br.edu.utfpr.turismoapi.repositories;

import br.edu.utfpr.turismoapi.models.Booking;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
    
}