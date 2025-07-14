package com.example.userapi.usecases.factory.usuario;

import com.example.userapi.services.UsuarioService;
import com.example.userapi.usecases.usuario.buscarporid.BuscarUsuarioPorIdUseCase;
import com.example.userapi.usecases.usuario.buscarporid.converter.BuscarUsuarioPorIdOutputConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class BuscarUsuarioPorIdUseCaseFactory {

    @Bean
    @DependsOn("buscarUsuarioPorIdOutputConverter")
    public BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase(UsuarioService usuarioService,
                                                               BuscarUsuarioPorIdOutputConverter outputConverter) {
        return BuscarUsuarioPorIdUseCase.builder()
                .usuarioService(usuarioService)
                .outputConverter(outputConverter)
                .build();
    }

    @Bean
    public BuscarUsuarioPorIdOutputConverter buscarUsuarioPorIdOutputConverter() {
        return BuscarUsuarioPorIdOutputConverter.builder().build();
    }

}
