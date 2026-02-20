package org.example.gateway.usecase.factory.configuracoes;

import org.example.gateway.config.RotasPermissionadas;
import org.example.gateway.usecase.configuracoes.permissoes.ConfigurarPermissoesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurarPermissoesUseCaseFactory {

    @Bean
    public ConfigurarPermissoesUseCase criarConfigurarPermissoesUseCase(RotasPermissionadas rotasPermissionadas) {
        return ConfigurarPermissoesUseCase.builder()
                .rotasPermissionadas(rotasPermissionadas)
                .build();
    }

}
