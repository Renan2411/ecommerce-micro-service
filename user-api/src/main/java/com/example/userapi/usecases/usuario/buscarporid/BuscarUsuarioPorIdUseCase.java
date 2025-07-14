package com.example.userapi.usecases.usuario.buscarporid;

import com.example.userapi.entities.UsuarioEntity;
import com.example.userapi.exceptions.UsuarioNaoEncontradoException;
import com.example.userapi.exceptions.generics.GenericValidationException;
import com.example.userapi.services.UsuarioService;
import com.example.userapi.usecases.usuario.buscarporid.converter.BuscarUsuarioPorIdOutputConverter;
import lombok.Builder;

import java.util.Objects;

@Builder
public class BuscarUsuarioPorIdUseCase {

    private final UsuarioService usuarioService;
    private final BuscarUsuarioPorIdOutputConverter outputConverter;

    public BuscarUsuarioPorIdOutput executar(Long idUsuario) {
        validarEntrada(idUsuario);

        UsuarioEntity usuarioEntity = buscarUsuario(idUsuario);

        return outputConverter.converter(usuarioEntity);
    }

    private void validarEntrada(Long idUsuario) {
        if (Objects.isNull(idUsuario)) {
            throw new GenericValidationException("Ausência do id do usuário");
        }
    }

    private UsuarioEntity buscarUsuario(Long idUsuario) {
        return usuarioService.buscarPorId(idUsuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(idUsuario));
    }

}
