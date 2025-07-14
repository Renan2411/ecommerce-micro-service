package com.example.authapi.services.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "user-api", path = "/usuarios")
public class UsuarioIntegrationService {

    @GetMapping("/")

}
