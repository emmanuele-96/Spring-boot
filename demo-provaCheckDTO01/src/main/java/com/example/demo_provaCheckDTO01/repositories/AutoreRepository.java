package com.example.demo_provaCheckDTO01.repositories;

import com.example.demo_provaCheckDTO01.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Long> {
}
