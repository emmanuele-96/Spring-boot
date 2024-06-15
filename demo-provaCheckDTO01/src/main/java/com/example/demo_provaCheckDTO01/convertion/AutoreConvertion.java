package com.example.demo_provaCheckDTO01.convertion;

import com.example.demo_provaCheckDTO01.dtos.AutoreDTO;
import com.example.demo_provaCheckDTO01.entities.Autore;

public class AutoreConvertion {
    public static AutoreDTO entityToDTO(Autore autore) {
        AutoreDTO autoreDTO = new AutoreDTO();
        autoreDTO.setId(autore.getId());
        autoreDTO.setName(autore.getName());
        autoreDTO.setDateOfBirth(autore.getDateOfBirth());
        autoreDTO.setNazionality(autore.getNazionality());
        return autoreDTO;
    }
    public static Autore dtoTOEntity(AutoreDTO autoreDTO) {
        Autore autore = new Autore();
        autore.setId(autoreDTO.getId());
        autore.setName(autoreDTO.getName());
        autore.setDateOfBirth(autoreDTO.getDateOfBirth());
        autore.setNazionality(autoreDTO.getNazionality());
        return autore;
    }
}
