package com.example.userapi.usecases.usuario.buscarporid.converter;

import com.example.userapi.entities.UsuarioEntity;
import com.example.userapi.usecases.usuario.buscarporid.BuscarUsuarioPorIdOutput;
import lombok.Builder;

@Builder
public class BuscarUsuarioPorIdOutputConverter {

    public BuscarUsuarioPorIdOutput converter(UsuarioEntity usuarioEntity){
        return BuscarUsuarioPorIdOutput.builder()
                .id(usuarioEntity.getId())
                .email(usuarioEntity.getEmail())
                .cpf(usuarioEntity.getCpf())
                .login(usuarioEntity.getLogin())
                .dataNascimento(usuarioEntity.getDataNascimento())
                .build();
    }

}
