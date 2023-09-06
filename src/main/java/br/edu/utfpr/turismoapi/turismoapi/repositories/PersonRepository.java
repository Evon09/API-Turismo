package br.edu.utfpr.turismoapi.turismoapi.repositories;

import br.edu.utfpr.turismoapi.turismoapi.models.Pessoa;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Pessoa, UUID> {
    
}
