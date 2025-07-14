package com.example.userapi.exceptions;

import com.example.userapi.exceptions.generics.GenericNotFoundException;

public class RoleNaoEncontradaException extends GenericNotFoundException {

    public RoleNaoEncontradaException(String nome) {
        super(String.format("Role '%s' não encontrada.", nome));
    }

}
