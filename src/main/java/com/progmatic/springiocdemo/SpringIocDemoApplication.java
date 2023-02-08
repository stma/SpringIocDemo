package com.progmatic.springiocdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIocDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIocDemoApplication.class, args);
    }

}


/*
    @SpringBootApplication =
        - @SpringBootConfiguration
        - @EnableAutoConfiguration
        - @ComponentScan
 */