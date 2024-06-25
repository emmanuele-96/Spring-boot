package com.example.demo_customqueries02.servicies;

import com.example.demo_customqueries02.entities.Flight;
import com.example.demo_customqueries02.entities.STATUSES;
import com.example.demo_customqueries02.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> provisioning(){
        List<Flight> flights = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            Flight flight = new Flight();
            flight.setFromAirport(generatedRandomString());
            flight.setToAirport(generatedRandomString());
            flight.setStatus(STATUSES.ONTIME);
            flights.add(flight);
        }
        return flightRepository.saveAll(flights);
    }

    public String generatedRandomString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    public List<Flight> getOntimeFlights() {
        return flightRepository.findByStatus(STATUSES.ONTIME.toString());
    }
    public List<Flight> getFlightsByStatuses(String p1, String p2) {
        return flightRepository.findFlightsByStatuses(p1, p2);
    }

}
