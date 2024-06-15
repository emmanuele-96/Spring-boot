package com.example.demo_provaCheckDTO01.dtos;

public class AutoreDTO {
    private Long id;
    private String name;
    private String dateOfBirth;
    private String nazionality;

    public AutoreDTO() {
    }

    public AutoreDTO(Long id, String name, String dateOfBirth, String nazionality) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nazionality = nazionality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNazionality() {
        return nazionality;
    }

    public void setNazionality(String nazionality) {
        this.nazionality = nazionality;
    }
}
