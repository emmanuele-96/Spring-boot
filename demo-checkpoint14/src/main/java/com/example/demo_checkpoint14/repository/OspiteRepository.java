package com.example.demo_checkpoint14.repository;

import com.example.demo_checkpoint14.entities.Ospite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OspiteRepository extends JpaRepository<Ospite, Long> {
}
