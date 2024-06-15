package com.example.demo_checkpoint14.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Ospite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    @Column(unique = true)
    private String cf;
    @Column(unique = true)
    private String cell;
    @Column(unique = true)
    private String email;

    public Ospite() {
    }

    public Ospite(Long id, String fullName, String cf, String cell, String email) {
        this.id = id;
        this.fullName = fullName;
        this.cf = cf;
        this.cell = cell;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
