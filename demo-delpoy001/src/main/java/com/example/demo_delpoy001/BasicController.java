package com.example.demo_delpoy001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/devName")
    public class BasicController {
        @Autowired
        private Environment environment;
        @GetMapping("/")
        public String name() {
           String devName = environment.getProperty("devName");
           return devName;
        }
}
