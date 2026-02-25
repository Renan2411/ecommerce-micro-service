package org.example.gateway.usecase.factory.configuracoes;

import org.example.gateway.utils.JsonUtils;
import org.example.gateway.utils.RotasPermissionadasAuthFilterUtils;
import org.example.gateway.services.RotasPermissionadasService;
import org.example.gateway.usecase.configuracoes.permissoes.ConfigurarPermissoesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurarPermissoesUseCaseFactory {

    @Bean
    public ConfigurarPermissoesUseCase criarConfigurarPermissoesUseCase(RotasPermissionadasAuthFilterUtils rotasPermissionadasAuthFilterUtils,
                                                                        JsonUtils jsonUtils,
                                                                        RotasPermissionadasService rotasPermissionadasService) {
        return ConfigurarPermissoesUseCase.builder()
                .rotasPermissionadasAuthFilterUtils(rotasPermissionadasAuthFilterUtils)
                .jsonUtils(jsonUtils)
                .rotasPermissionadasService(rotasPermissionadasService)
                .build();
    }

}
