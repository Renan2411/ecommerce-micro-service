package com.example.authapi.services.integration.usuario;

import com.example.authapi.services.integration.usuario.responses.BuscarUsuarioPorCpfResponse;
import org.springframework.web.bind.annotation.RequestParam;

public interface IUsuarioIntegrationService {

    BuscarUsuarioPorCpfResponse buscarPorCpf(@RequestParam String cpf);

}
