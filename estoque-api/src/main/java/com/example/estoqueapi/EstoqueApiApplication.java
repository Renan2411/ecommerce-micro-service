package com.example.estoqueapi;

import com.example.estoqueapi.entities.dto.RoutePermissionsDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableConfigurationProperties(RoutePermissionsDTO.class)
public class EstoqueApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstoqueApiApplication.class, args);
    }

}
