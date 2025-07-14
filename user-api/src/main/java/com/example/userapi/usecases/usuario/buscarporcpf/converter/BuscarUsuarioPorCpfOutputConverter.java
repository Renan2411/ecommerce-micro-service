package com.example.userapi.usecases.usuario.buscarporcpf.converter;

import com.example.userapi.entities.UsuarioEntity;
import com.example.userapi.usecases.usuario.buscarporcpf.BuscarUsuarioPorCpfOutput;
import lombok.Builder;

@Builder
public class BuscarUsuarioPorCpfOutputConverter {

    public BuscarUsuarioPorCpfOutput converter(UsuarioEntity usuarioEntity){
        return BuscarUsuarioPorCpfOutput.builder()
                .id(usuarioEntity.getId())
                .email(usuarioEntity.getEmail())
                .cpf(usuarioEntity.getCpf())
                .login(usuarioEntity.getLogin())
                .dataNascimento(usuarioEntity.getDataNascimento())
                .build();
    }

}
