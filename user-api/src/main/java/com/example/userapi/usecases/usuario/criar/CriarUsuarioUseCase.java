package com.example.userapi.usecases.usuario.criar;

import com.example.userapi.entities.RoleEntity;
import com.example.userapi.entities.UsuarioEntity;
import com.example.userapi.entities.UsuarioRoleEntity;
import com.example.userapi.exceptions.CpfJaExistenteException;
import com.example.userapi.exceptions.RoleNaoEncontradaException;
import com.example.userapi.services.RoleService;
import com.example.userapi.services.UsuarioRoleService;
import com.example.userapi.services.UsuarioService;
import com.example.userapi.usecases.usuario.criar.converter.CriarUsuarioOutputConverter;
import com.example.userapi.utils.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Objects;

@Builder
@AllArgsConstructor
public class CriarUsuarioUseCase {

    private static final String ROLE_CLIENTE = "CLIENTE";
    private final UsuarioService usuarioService;
    private final RoleService roleService;
    private final UsuarioRoleService usuarioRoleService;
    private final CriarUsuarioOutputConverter outputConverter;

    public CriarUsuarioOutput executar(CriarUsuarioInput entrada) {
        validarEntrada(entrada);
        validarSeCpfJaExiste(entrada);

        UsuarioEntity usuarioEntity = criarUsuarioEntity(entrada);
        usuarioEntity = salvarUsuario(usuarioEntity);

        RoleEntity roleEntity = buscarRoleCliente();
        UsuarioRoleEntity usuarioRoleEntity = criarUsuarioRoleEntity(usuarioEntity, roleEntity);

        salvarUsuarioRoleEntity(usuarioRoleEntity);

        return outputConverter.converter(usuarioEntity);
    }

    private void validarEntrada(CriarUsuarioInput entrada) {
        Validator.of(entrada)
                .validate(Objects.nonNull(entrada.getNome()), "Ausência do nome do usuário")
                .validate(Objects.nonNull(entrada.getEmail()), "Ausência do email do usuário")
                .validate(Objects.nonNull(entrada.getSenha()), "Ausência da senha do usuário")
                .validate(Objects.nonNull(entrada.getLogin()), "Ausência do login do usuário")
                .validate(Objects.nonNull(entrada.getCpf()), "Ausência do cpf do usuário")
                .get();
    }

    private void validarSeCpfJaExiste(CriarUsuarioInput entrada) {
        if (usuarioService.existePorCpf(entrada.getCpf())) {
            throw new CpfJaExistenteException(entrada.getCpf());
        }
    }

    private UsuarioEntity criarUsuarioEntity(CriarUsuarioInput entrada) {
        return UsuarioEntity.builder()
                .nome(entrada.getNome())
                .cpf(entrada.getCpf())
                .email(entrada.getEmail())
                .senha(entrada.getSenha())
                .login(entrada.getLogin())
                .dataNascimento(entrada.getDataNascimento())
                .build();
    }

    private UsuarioEntity salvarUsuario(UsuarioEntity usuarioEntity) {
        return usuarioService.criar(usuarioEntity);
    }

    private RoleEntity buscarRoleCliente() {
        return roleService.buscarPorNome(ROLE_CLIENTE)
                .orElseThrow(() -> new RoleNaoEncontradaException(ROLE_CLIENTE));
    }

    private UsuarioRoleEntity criarUsuarioRoleEntity(UsuarioEntity usuarioEntity, RoleEntity roleEntity) {
        return UsuarioRoleEntity.builder()
                .usuarioEntity(usuarioEntity)
                .roleEntity(roleEntity)
                .build();
    }

    private UsuarioRoleEntity salvarUsuarioRoleEntity(UsuarioRoleEntity usuarioRoleEntity) {
        return usuarioRoleService.criar(usuarioRoleEntity);
    }

}
