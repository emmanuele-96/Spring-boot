package com.example.demowebapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {
    @RequestMapping(method = RequestMethod.GET, path = "/helloworld")
    public String helloWorld() {
        return "Hello World 2!";
    }
    @GetMapping(path = "/ciao1")
    public String ciao1(@RequestParam(required = true) String nome,
                       @RequestParam(required = false, defaultValue = "") String cognome) {
        return "Ciao " + nome + " " + cognome + "!";
    }
    @GetMapping(path = "/ciao")
    public String esercizio1(@RequestParam(required = true) String nome,
                       @RequestParam(required = false, defaultValue = "Lombardia") String provincia) {
        return "Ciao " + nome + ", " + "com'è il tempo in " + provincia + "?";
    }
}
