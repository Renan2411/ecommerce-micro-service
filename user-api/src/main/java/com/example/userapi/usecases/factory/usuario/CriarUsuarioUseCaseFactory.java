package com.example.userapi.usecases.factory.usuario;

import com.example.userapi.services.RoleService;
import com.example.userapi.services.UsuarioRoleService;
import com.example.userapi.services.UsuarioService;
import com.example.userapi.usecases.usuario.criar.CriarUsuarioInput;
import com.example.userapi.usecases.usuario.criar.CriarUsuarioUseCase;
import com.example.userapi.usecases.usuario.criar.converter.CriarUsuarioOutputConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class CriarUsuarioUseCaseFactory {

    @Bean
    @DependsOn("criarUsuarioOutputConverter")
    public CriarUsuarioUseCase criarUsuarioUseCase(UsuarioService usuarioService,
                                                   RoleService roleService,
                                                   UsuarioRoleService usuarioRoleService,
                                                   CriarUsuarioOutputConverter outputConverter) {
        return CriarUsuarioUseCase.builder()
                .usuarioService(usuarioService)
                .roleService(roleService)
                .usuarioRoleService(usuarioRoleService)
                .outputConverter(outputConverter)
                .build();
    }

    @Bean
    public CriarUsuarioOutputConverter criarUsuarioOutputConverter() {
        return CriarUsuarioOutputConverter.builder().build();
    }

}
