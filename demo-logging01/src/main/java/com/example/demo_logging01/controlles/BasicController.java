package com.example.demo_logging01.controlles;

import com.example.demo_logging01.excepsions.BasicException;
import com.example.demo_logging01.servicies.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BasicController {
    Logger logger = LoggerFactory.getLogger(BasicController.class);
    private final BasicService basicService;
    @Value("${MY_APP_VALUE1}")
    private int value1;

    @Value("${MY_APP_VALUE2}")
    private int value2;

    public BasicController(BasicService basicService) {
        this.basicService = basicService;
    }

    @GetMapping
    public String welcome() {
        logger.info("Accessed welcome endpoint");
        return "Welcome to the Spring Boot Application!";
    }

    @GetMapping("/exp")
    public String exp() {
        logger.debug("Starting exponentiation calculation");
        double result = basicService.calculateExponentiation(value1, value2);
        logger.debug("Finished exponentiation calculation");
        return "Exponentiation result of " + value1 + " raised to the power of " + value2 + " is " + result;
    }

    @GetMapping("/get-errors")
    public void getErrors() {
        logger.error("Custom error endpoint triggered");
        throw new BasicException("This is a custom error!");
    }
}
