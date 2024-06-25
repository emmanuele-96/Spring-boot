package com.example.demo_customqueries02.entities;

import jakarta.persistence.*;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromAirport;
    private String toAirport;
    @Enumerated  (EnumType.STRING)
    private STATUSES status = STATUSES.ONTIME;

    public Flight() {
    }

    public Flight(Long id, String fromAirport, String toAirport, STATUSES status) {
        this.id = id;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public STATUSES getStatus() {
        return status;
    }

    public void setStatus(STATUSES status) {
        this.status = status;
    }
}
