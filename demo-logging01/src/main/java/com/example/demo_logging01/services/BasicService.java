package com.example.demo_logging01.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    @Value("${value1}")
    private int value1;

    @Value("${value2}")
    private int value2;
    private static final Logger logger = LoggerFactory.getLogger(BasicService.class);

    public double calculateExponentiation() {
        logger.debug("Calculating {} raised to the power of {}", value1, value2);
        double result = Math.pow(value1, value2);
        logger.debug("Calculating result {}", result);
        return result;
    }
}
