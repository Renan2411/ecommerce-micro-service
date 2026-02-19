package com.example.authapi.services.integration.usuario;

import com.example.authapi.services.integration.usuario.request.BuscarUsuarioPorCpfRequest;
import com.example.authapi.services.integration.usuario.responses.BuscarUsuarioPorCpfResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioIntegrationServiceImpl implements IUsuarioIntegrationService {

    private final BuscarUsuarioPorCpfRequest buscarUsuarioPorCpfRequest;

    @Override
    public BuscarUsuarioPorCpfResponse buscarPorCpf(String cpf)  {
       return buscarUsuarioPorCpfRequest.executar(cpf);
    }

}
