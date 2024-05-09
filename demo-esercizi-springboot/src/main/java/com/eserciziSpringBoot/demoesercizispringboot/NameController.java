package com.eserciziSpringBoot.demoesercizispringboot;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/v4")
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
