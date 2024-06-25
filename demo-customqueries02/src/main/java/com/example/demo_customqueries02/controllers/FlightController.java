package com.example.demo_customqueries02.controllers;

import com.example.demo_customqueries02.entities.Flight;
import com.example.demo_customqueries02.entities.STATUSES;
import com.example.demo_customqueries02.repositories.FlightRepository;
import com.example.demo_customqueries02.servicies.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/provision")
    public List<Flight> provisionFlights(@RequestParam(value = "n", defaultValue = "100") int n) {
        return flightService.provisioning();

    }
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }
    @GetMapping("/ontime")
    public List<Flight> getOntimeFlights() {
        return flightService.getOntimeFlights();
    }
    @GetMapping("/status")
    public List<Flight> getFlightsByStatuses(
            @RequestParam("p1") String p1,
            @RequestParam("p2") String p2) {
        return flightService.getFlightsByStatuses(p1, p2);
    }
}
