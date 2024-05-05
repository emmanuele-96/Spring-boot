package com.example.demowebapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
public class Esercizio2 {
    @GetMapping(path = "/ciao2/{provincia}")
    public User esercizio2(
            @PathVariable String provincia,
            @RequestParam(required = true) String nome,
            @RequestParam(required = false, defaultValue = "Ciao Giuseppe, com'è il tempo in Lombardia?") String saluto)
    {
        return new User(nome, provincia, saluto);

    }
}
