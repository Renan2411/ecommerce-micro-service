package com.example.userapi.usecases.usuario.buscarporcpf;

import com.example.userapi.entities.RoleEntity;
import com.example.userapi.entities.UsuarioEntity;
import com.example.userapi.entities.UsuarioRoleEntity;
import com.example.userapi.exceptions.UsuarioNaoEncontradoException;
import com.example.userapi.exceptions.generics.GenericNotFoundException;
import com.example.userapi.services.UsuarioRoleService;
import com.example.userapi.services.UsuarioService;
import com.example.userapi.usecases.usuario.buscarporcpf.converter.BuscarUsuarioPorCpfOutputConverter;
import lombok.Builder;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
public class BuscarUsuarioPorCpfUseCase {

    private final UsuarioService usuarioService;
    private final UsuarioRoleService usuarioRoleService;
    private final BuscarUsuarioPorCpfOutputConverter outputConverter;

    public BuscarUsuarioPorCpfOutput executar(String cpf) {
        validarEntrada(cpf);

        UsuarioEntity usuario = buscarUsuario(cpf);
        Set<RoleEntity> rolesUsuario = buscarRolesUsuarios(usuario.getId());
        return outputConverter.converter(usuario, rolesUsuario);
    }

    private void validarEntrada(String cpf) {
        if (Objects.isNull(cpf)) {
            throw new GenericNotFoundException("Ausência do cpf do usuário");
        }
    }

    private UsuarioEntity buscarUsuario(String cpf) {
        return usuarioService.buscarPorCpf(cpf).
                orElseThrow(() -> new UsuarioNaoEncontradoException(cpf, UsuarioNaoEncontradoException.TipoLogin.CPF.name()));
    }

    private Set<RoleEntity> buscarRolesUsuarios(Long idUsuario) {
        List<UsuarioRoleEntity> usuarioRoleEntities = usuarioRoleService.buscarListagemPorIdUsuario(idUsuario);

        return usuarioRoleEntities.stream()
                .map(usuarioRoleEntity -> RoleEntity.builder()
                        .id(usuarioRoleEntity.getRoleEntity().getId())
                        .nome(usuarioRoleEntity.getRoleEntity().getNome())
                        .descricao(usuarioRoleEntity.getRoleEntity().getDescricao())
                        .build()
                ).collect(Collectors.toSet());
    }

}
