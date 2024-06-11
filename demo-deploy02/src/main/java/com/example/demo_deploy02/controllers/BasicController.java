package com.example.demo_deploy02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
@RestController
@RequestMapping("/sum")
public class BasicController {
    @GetMapping
    public Integer numberRandom() {
        Random sumRandom = new Random();
        Integer num1 = sumRandom.nextInt(9);
        Integer num2 = sumRandom.nextInt(9);
        return num1 + num2;
    }
}


