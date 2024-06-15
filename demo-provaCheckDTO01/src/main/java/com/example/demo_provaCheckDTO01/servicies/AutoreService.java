package com.example.demo_provaCheckDTO01.servicies;

import com.example.demo_provaCheckDTO01.convertion.AutoreConvertion;
import com.example.demo_provaCheckDTO01.dtos.AutoreDTO;
import com.example.demo_provaCheckDTO01.entities.Autore;
import com.example.demo_provaCheckDTO01.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;

    public AutoreDTO create(AutoreDTO autoreDTO) {
        Autore autore = AutoreConvertion.dtoTOEntity(autoreDTO);
        autoreRepository.save(autore);
        AutoreDTO autoreDTO1 = AutoreConvertion.entityToDTO(autore);
        return autoreDTO1;
    }

    public List<AutoreDTO> getAll() {
        List<Autore> autoreList = autoreRepository.findAll();
        List<AutoreDTO> autoreDTOList = new ArrayList<>();
        for (Autore autore : autoreList) {
            AutoreDTO autoreDTO = AutoreConvertion.entityToDTO(autore);
            autoreDTOList.add(autoreDTO);
        }
        return autoreDTOList;
    }
    public AutoreDTO getByID(Long id) {
        Autore autore = autoreRepository.findById(id).orElse(null);
        AutoreDTO autoreDTO = AutoreConvertion.entityToDTO(autore);
        return autoreDTO;
    }
    public AutoreDTO update(Long id, AutoreDTO autoreDTO) {
        Optional<Autore> autore = autoreRepository.findById(id);
        if (autore.isPresent()) {
            Autore autore1 = autore.get();
            autore1.setName(autoreDTO.getName());
            autore1.setDateOfBirth(autoreDTO.getDateOfBirth());
            autore1.setNazionality(autoreDTO.getNazionality());
        }
        return autoreDTO;
    }
    public void delete(Long id) {
        autoreRepository.deleteById(id);
    }

}
