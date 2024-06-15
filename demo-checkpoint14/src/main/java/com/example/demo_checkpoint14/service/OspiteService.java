package com.example.demo_checkpoint14.service;

import com.example.demo_checkpoint14.entities.Ospite;
import com.example.demo_checkpoint14.repository.OspiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OspiteService {
    @Autowired
    private OspiteRepository ospiteRepository;
    public Ospite create(Ospite ospite) {
        return ospiteRepository.save(ospite);
    }

}
