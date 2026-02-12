package com.example.authapi.services.integration.usuario;

import com.example.authapi.entities.UserEntity;
import com.example.authapi.services.integration.usuario.responses.BuscarUsuarioPorCpfResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "user-api", path = "/usuarios")
public interface UsuarioIntegrationService {

    @GetMapping("/cpf/{cpf}")
    ResponseEntity<UserEntity> buscarPorCpf(@RequestParam String cpf);

}
