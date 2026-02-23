package org.example.gateway.usecase.factory.configuracoes;

import org.example.gateway.config.JsonUtils;
import org.example.gateway.config.RotasPermissionadasAuthFilter;
import org.example.gateway.services.RotasPermissionadasService;
import org.example.gateway.usecase.configuracoes.permissoes.ConfigurarPermissoesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurarPermissoesUseCaseFactory {

    @Bean
    public ConfigurarPermissoesUseCase criarConfigurarPermissoesUseCase(RotasPermissionadasAuthFilter rotasPermissionadasAuthFilter,
                                                                        JsonUtils jsonUtils,
                                                                        RotasPermissionadasService rotasPermissionadasService) {
        return ConfigurarPermissoesUseCase.builder()
                .rotasPermissionadasAuthFilter(rotasPermissionadasAuthFilter)
                .jsonUtils(jsonUtils)
                .rotasPermissionadasService(rotasPermissionadasService)
                .build();
    }

}
