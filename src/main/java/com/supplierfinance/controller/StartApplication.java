package com.supplierfinance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.supplierfinance.domain"})
@ComponentScan({"com.supplierfinance"})
@EnableJpaRepositories(basePackages = {"com.supplierfinance.repository"})
@SpringBootApplication
public class StartApplication {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}