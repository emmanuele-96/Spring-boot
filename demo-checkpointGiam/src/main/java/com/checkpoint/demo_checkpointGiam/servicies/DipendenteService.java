package com.checkpoint.demo_checkpointGiam.servicies;

import com.checkpoint.demo_checkpointGiam.entities.Dipendente;
import com.checkpoint.demo_checkpointGiam.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Dipendente creaDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }


    public Dipendente getDipendenteByID(Long id) {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(id);
        if(dipendenteOptional.isPresent()) {
            return dipendenteOptional.get();
        }
        return null;
    }
    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Optional<Dipendente> updateDipendente(Long id, Dipendente dipendentedettagli) {
        Optional<Dipendente> optionalDipendente = dipendenteRepository.findById(id);
        if (optionalDipendente.isPresent()) {
            Dipendente dipendente = optionalDipendente.get();
            dipendente.setFullName(dipendentedettagli.getFullName());
            dipendente.setCodiceFiscale(dipendentedettagli.getCodiceFiscale());
            dipendente.setPosizioneLavorativa(dipendentedettagli.getPosizioneLavorativa());
            dipendente.setEmail(dipendentedettagli.getEmail());
            Dipendente dipendenteSalvato = dipendenteRepository.saveAndFlush(dipendente);
            return Optional.of(dipendenteSalvato);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteDipendente(Long id) {
        if (dipendenteRepository.existsById(id)) {
            dipendenteRepository.existsById(id);
            return true;
        } else {
            return false;
        }
    }
}
