package com.example.userapi.usecases.usuario.buscarporcpf.converter;

import com.example.userapi.entities.RoleEntity;
import com.example.userapi.entities.UsuarioEntity;
import com.example.userapi.usecases.usuario.buscarporcpf.BuscarUsuarioPorCpfOutput;
import lombok.Builder;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
public class BuscarUsuarioPorCpfOutputConverter {

    public BuscarUsuarioPorCpfOutput converter(UsuarioEntity usuarioEntity, Set<RoleEntity> roleEntitySet) {
        return BuscarUsuarioPorCpfOutput.builder()
                .id(usuarioEntity.getId())
                .email(usuarioEntity.getEmail())
                .cpf(usuarioEntity.getCpf())
                .login(usuarioEntity.getLogin())
                .name(usuarioEntity.getName())
                .password(usuarioEntity.getPassword())
                .dataNascimento(usuarioEntity.getDataNascimento())
                .roles(roleEntitySet.stream()
                        .map(roleEntity -> BuscarUsuarioPorCpfOutput.Roles.builder()
                                .id(roleEntity.getId())
                                .nome(roleEntity.getNome())
                                .descricao(roleEntity.getDescricao())
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }

}
