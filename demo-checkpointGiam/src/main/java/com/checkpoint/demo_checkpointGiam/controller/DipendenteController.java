package com.checkpoint.demo_checkpointGiam.controller;

import com.checkpoint.demo_checkpointGiam.entities.Dipendente;
import com.checkpoint.demo_checkpointGiam.servicies.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dipendente")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;
    @PostMapping("")
    public Dipendente creaDipendente (@RequestBody Dipendente dipendente) {
       return dipendenteService.creaDipendente(dipendente);
    }
    @GetMapping("/{id}")
    public Dipendente getDipendenteByID(@PathVariable Long id) {
            return dipendenteService.getDipendenteByID(id);
    }
    @GetMapping("/")
    public ResponseEntity<List<Dipendente>> getAllDipendenti() {
        List<Dipendente> dipendente = dipendenteService.getAllDipendenti();
        if(dipendente.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(dipendente);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Dipendente>> updateDipendente(@PathVariable Long id, @RequestBody Dipendente dettagliDipendente) {
        Optional<List<Dipendente>> existingDipendente = Optional.ofNullable(Collections.singletonList(dipendenteService.getDipendenteByID(id)));

        if (existingDipendente.isPresent()) {
            Optional<Dipendente> updatedDipendente = dipendenteService.updateDipendente(id, dettagliDipendente);  
            return ResponseEntity.ok(updatedDipendente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
