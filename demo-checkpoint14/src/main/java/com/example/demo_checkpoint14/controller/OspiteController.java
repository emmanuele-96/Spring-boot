package com.example.demo_checkpoint14.controller;

import com.example.demo_checkpoint14.entities.Ospite;
import com.example.demo_checkpoint14.service.OspiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ospiti")
public class OspiteController {
    @Autowired
    private OspiteService ospiteService;
    @PostMapping("")
    public Ospite crea(@RequestBody Ospite ospite) {
        return ospiteService.create(ospite);
    }
}
