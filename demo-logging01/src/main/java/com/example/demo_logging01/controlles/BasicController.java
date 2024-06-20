package com.example.demo_logging01.controlles;

import com.example.demo_logging01.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BasicController {

    Logger logger = LoggerFactory.getLogger(BasicController.class);
    private final BasicService basicService;

    public BasicController(BasicService basicService) {
        this.basicService = basicService;
    }

    @GetMapping
    public String welcome() {
        logger.info("Accessed welcome endpoint");
        return "Welcome to the Spring Boot Application!";
    }

    @GetMapping("/exp")
    public double exp() {
        logger.debug("Finished exponentiation calculation");
        return basicService.calculateExponentiation();
    }

    @GetMapping("/get-errors")
    public void getErrors() {
        logger.error("Custom error endpoint triggered");
    }
}
