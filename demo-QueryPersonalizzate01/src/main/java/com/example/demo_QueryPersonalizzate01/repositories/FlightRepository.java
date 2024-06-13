package com.example.demo_QueryPersonalizzate01.repositories;

import com.example.demo_QueryPersonalizzate01.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}

