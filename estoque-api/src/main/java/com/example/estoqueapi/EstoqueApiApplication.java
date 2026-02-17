package com.example.estoqueapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EstoqueApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstoqueApiApplication.class, args);
    }

}
