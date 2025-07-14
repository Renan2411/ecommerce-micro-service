package com.example.userapi.usecases.usuario.buscarporcpf;

import com.example.userapi.entities.UsuarioEntity;
import com.example.userapi.exceptions.UsuarioNaoEncontradoException;
import com.example.userapi.exceptions.generics.GenericNotFoundException;
import com.example.userapi.services.UsuarioService;
import com.example.userapi.usecases.usuario.buscarporcpf.converter.BuscarUsuarioPorCpfOutputConverter;
import lombok.Builder;

import java.util.Objects;

@Builder
public class BuscarUsuarioPorCpfUseCase {

    private final UsuarioService usuarioService;
    private final BuscarUsuarioPorCpfOutputConverter outputConverter;

    public BuscarUsuarioPorCpfOutput executar(String cpf) {
        validarEntrada(cpf);

        UsuarioEntity usuario = buscarUsuario(cpf);
        return outputConverter.converter(usuario);
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


}
