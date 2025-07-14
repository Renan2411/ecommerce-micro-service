package com.example.userapi.exceptions;

import com.example.userapi.exceptions.generics.GenericNotFoundException;

public class UsuarioNaoEncontradoException extends GenericNotFoundException {

    public UsuarioNaoEncontradoException(Long id) {
        super(String.format("Usuário de id %d não encontrado", id));
    }

}
