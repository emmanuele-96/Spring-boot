package com.interceptor2.demo_interceptor2.controllers;

import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/month")
public class MonthController {
    private String theMonthIs(){
        return "the month is ";
    }
}
