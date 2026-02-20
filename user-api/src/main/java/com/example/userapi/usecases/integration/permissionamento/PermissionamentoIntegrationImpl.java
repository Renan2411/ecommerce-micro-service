package com.example.userapi.usecases.integration.permissionamento;

import com.example.userapi.usecases.integration.permissionamento.requests.EnviarPathsPermissionadosRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
@AllArgsConstructor
public class PermissionamentoIntegrationImpl implements IPermissionamentoIntegration {

    private final EnviarPathsPermissionadosRequest enviarPathsPermissionadosRequest;

    @Override
    public void enviarPathsPermissionados() {
        enviarPathsPermissionadosRequest.executar();
    }

}
