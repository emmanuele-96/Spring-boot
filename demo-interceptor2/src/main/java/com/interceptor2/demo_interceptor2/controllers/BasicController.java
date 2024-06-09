package com.interceptor2.demo_interceptor2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcomes")
public class BasicController {
    @GetMapping("")
    public String sayWelcome() {
        return "Welcome";
    }
}
