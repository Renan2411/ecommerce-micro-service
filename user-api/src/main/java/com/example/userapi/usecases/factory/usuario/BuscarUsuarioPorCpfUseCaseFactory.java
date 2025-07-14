package com.example.userapi.usecases.factory.usuario;

import com.example.userapi.services.UsuarioService;
import com.example.userapi.usecases.usuario.buscarporcpf.BuscarUsuarioPorCpfUseCase;
import com.example.userapi.usecases.usuario.buscarporcpf.converter.BuscarUsuarioPorCpfOutputConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class BuscarUsuarioPorCpfUseCaseFactory {

    @Bean
    @DependsOn("buscarUsuarioPorCpfOutputConverter")
    public BuscarUsuarioPorCpfUseCase buscarUsuarioPorCpfUseCase(UsuarioService usuarioService,
                                                                 BuscarUsuarioPorCpfOutputConverter outputConverter) {
        return BuscarUsuarioPorCpfUseCase.builder()
                .usuarioService(usuarioService)
                .outputConverter(outputConverter)
                .build();
    }

    @Bean
    public BuscarUsuarioPorCpfOutputConverter buscarUsuarioPorCpfOutputConverter() {
        return BuscarUsuarioPorCpfOutputConverter.builder().build();
    }

}
