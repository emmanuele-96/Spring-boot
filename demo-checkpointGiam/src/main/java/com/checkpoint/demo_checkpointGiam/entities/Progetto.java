package com.checkpoint.demo_checkpointGiam.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Progetto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToMany
    @JoinTable(name = "dipendente_progetto",
            joinColumns = @JoinColumn(name = "dipendente_id"),
            inverseJoinColumns = @JoinColumn(name = "progetto_id"))
    private Set<Dipendente> dipendenti = new HashSet<>();
    @Column
    private String descrizioneProgetto;

    public Progetto() {
    }

    public Progetto(Long id, String name, String descrizioneProgetto) {
        this.id = id;
        this.name = name;
        this.descrizioneProgetto = descrizioneProgetto;
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

    public String getDescrizioneProgetto() {
        return descrizioneProgetto;
    }

    public void setDescrizioneProgetto(String descrizioneProgetto) {
        this.descrizioneProgetto = descrizioneProgetto;
    }
}
