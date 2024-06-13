package com.example.demo_QueryPersonalizzate01.controllers;

import com.example.demo_QueryPersonalizzate01.entities.Flight;
import com.example.demo_QueryPersonalizzate01.servicies.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/create")
    public List<Flight> create() {
        return flightService.provisioning();
    }

    @GetMapping
    public List<Flight> getAll() {
        return flightService.getAll();
    }
}
