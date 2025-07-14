package com.example.userapi.usecases.usuario.criar.converter;

import com.example.userapi.entities.UsuarioEntity;
import com.example.userapi.usecases.usuario.criar.CriarUsuarioOutput;
import lombok.Builder;

@Builder
public class CriarUsuarioOutputConverter {

    public CriarUsuarioOutput converter(UsuarioEntity usuarioEntity){
        return CriarUsuarioOutput.builder()
                .id(usuarioEntity.getId())
                .email(usuarioEntity.getEmail())
                .cpf(usuarioEntity.getCpf())
                .login(usuarioEntity.getLogin())
                .dataNascimento(usuarioEntity.getDataNascimento())
                .build();
    }

}
