package com.example.demo_provaCheckDTO01.controller;

import com.example.demo_provaCheckDTO01.dtos.AutoreDTO;
import com.example.demo_provaCheckDTO01.servicies.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("")
    public AutoreDTO create(@RequestBody AutoreDTO autoreDTO) {
        return autoreService.create(autoreDTO);
    }
    @GetMapping("/")
    public List<AutoreDTO> getAll() {
        return autoreService.getAll();
    }
    @GetMapping("/{id}")
    public AutoreDTO getById(@PathVariable Long id) {
        return autoreService.getByID(id);
    }
    @PutMapping("/{id}")
    public AutoreDTO update(@PathVariable Long id, @RequestBody AutoreDTO autoreDTO) {
        return autoreService.update(id, autoreDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
    autoreService.delete(id);
    }
}
