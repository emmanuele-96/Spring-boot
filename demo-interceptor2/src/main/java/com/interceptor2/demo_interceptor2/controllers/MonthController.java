package com.interceptor2.demo_interceptor2.controllers;

import com.interceptor2.demo_interceptor2.entities.Month;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/month")
public class MonthController {
    @GetMapping("/")
    private Month getMonth(@RequestAttribute("monthNumber") Month month){
        return month;
    }
}
