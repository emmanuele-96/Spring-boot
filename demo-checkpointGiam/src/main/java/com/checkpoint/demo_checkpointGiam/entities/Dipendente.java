package com.checkpoint.demo_checkpointGiam.entities;

import jakarta.persistence.*;
/*Definire un’entità Employee con i seguenti attributi:
        - ID: Identificativo unico del dipendente.
        - FullName: Nome e cognome del dipendente.
- CF: Codice fiscale.
        - JobPosition: Posizione lavorativa.
        - Email: Email del dipendente.*/
@Entity
@Table
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String codiceFiscale;
    @Column(nullable = false)
    private String posizioneLavorativa;
    @Column(nullable = false, unique = true)
    private  String email;

    public Dipendente() {
    }

    public Dipendente(Long id, String fullName, String codiceFiscale, String posizioneLavorativa, String email) {
        this.id = id;
        this.fullName = fullName;
        this.codiceFiscale = codiceFiscale;
        this.posizioneLavorativa = posizioneLavorativa;
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

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getPosizioneLavorativa() {
        return posizioneLavorativa;
    }

    public void setPosizioneLavorativa(String posizioneLavorativa) {
        this.posizioneLavorativa = posizioneLavorativa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
