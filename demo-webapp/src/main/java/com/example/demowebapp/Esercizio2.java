package com.example.demowebapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
public class Esercizio2 {
    @GetMapping(path = "/ciao2/{provincia}")
    public String esercizio2(
            @PathVariable String provincia,
            @RequestParam(required = true) String nome)

    {
        return "Ciao " + nome + " com'è il tempo in " + provincia + "?";
    }
}
