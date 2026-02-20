package com.example.estoqueapi.usecases.integration.permissionamento;

import com.example.estoqueapi.usecases.integration.permissionamento.requests.EnviarPathsPermissionadosRequest;
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
