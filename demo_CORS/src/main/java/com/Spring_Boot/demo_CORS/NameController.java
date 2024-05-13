package com.Spring_Boot.demo_CORS;

import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("/v5")
public class NameController {
    @GetMapping("/name")
    public String getName (
            @RequestParam String name) {
        return name;
    }

    @PostMapping("/reverce")
    public String reverce (
            @RequestParam String name) {
        StringBuilder reverceName = new StringBuilder(name).reverse();
        return reverceName.toString();
    }
}
