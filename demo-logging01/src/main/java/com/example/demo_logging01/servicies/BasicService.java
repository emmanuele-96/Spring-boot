package com.example.demo_logging01.servicies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BasicService {
    private static final Logger logger = LoggerFactory.getLogger(BasicService.class);

    public double calculateExponentiation(int base, int exponent) {
        logger.debug("Calculating {} raised to the power of {}", base, exponent);
        return Math.pow(base, exponent);
    }
}
