package com.checkpoint.demo_checkpointGiam.repository;

import com.checkpoint.demo_checkpointGiam.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
}
