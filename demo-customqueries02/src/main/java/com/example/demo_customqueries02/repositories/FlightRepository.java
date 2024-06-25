package com.example.demo_customqueries02.repositories;

import com.example.demo_customqueries02.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository <Flight, Long> {
    List<Flight> findByStatus(String status);
    @Query("SELECT f FROM Flight f WHERE f.status = :p1 OR f.status = :p2")
    List<Flight> findFlightsByStatuses(@Param("p1") String p1, @Param("p2") String p2);
}
