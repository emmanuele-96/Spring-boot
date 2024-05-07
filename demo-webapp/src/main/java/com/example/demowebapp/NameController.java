package com.example.demowebapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3")
public class NameController {
    @GetMapping("/name")
    public String getName (
            @RequestParam(required = true) String name) {
                return name ;
    }

    @PostMapping("/reverce")
    public String reverce (
            @RequestParam (required = true) String name) {
        StringBuilder reverceName = new StringBuilder(name).reverse();
        return reverceName.toString();
    }


}
