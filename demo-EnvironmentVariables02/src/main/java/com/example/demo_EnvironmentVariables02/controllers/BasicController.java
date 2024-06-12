package com.example.demo_EnvironmentVariables02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcomeMsg")
public class BasicController {
    @Autowired
    Environment environment;
    @GetMapping
    public String welcomeMsg() {
        String greeting = environment.getProperty("welcomeMsg");
        return greeting;
    }
}
