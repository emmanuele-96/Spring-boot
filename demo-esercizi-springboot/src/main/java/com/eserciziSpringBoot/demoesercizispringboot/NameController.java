package com.eserciziSpringBoot.demoesercizispringboot;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/v4")
public class NameController {
    @Operation(summary = "getName", description = "restituisce il nome (name) fornito")
        @GetMapping("/name")
        public String getName (
               @Parameter(description = "il nome (name) da restituire") @RequestParam String name) {
            return name;
        }
        @Operation(summary = "reverce", description = "restituisce il nome (name) al contrario")
        @PostMapping("/reverce")
        public String reverce (
               @Parameter(description = "il nome (name) che deve ritornare ma invertito") @RequestParam String name) {
            StringBuilder reverceName = new StringBuilder(name).reverse();
            return reverceName.toString();
        }
}
