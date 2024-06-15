package com.example.demo_.provaCheck01.controllers;

import com.example.demo_.provaCheck01.entities.Autore;
import com.example.demo_.provaCheck01.servicies.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autore")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("")
    public Autore crea(@RequestBody Autore autore) {
        return autoreService.create(autore);
    }

    @GetMapping("/")
    public List<Autore> getAll() {
        return autoreService.getAll();
    }
    @GetMapping("/{id}")
    public Autore getById(@PathVariable Long id) {
        return autoreService.getById(id);
    }
    @PutMapping("/{id}")
    public Autore update (@PathVariable  Long id, @RequestBody Autore autore) {
       return autoreService.update(id, autore);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        autoreService.delete(id);
    }
}
