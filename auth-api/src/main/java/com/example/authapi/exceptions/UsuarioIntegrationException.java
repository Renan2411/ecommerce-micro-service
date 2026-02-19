package com.example.authapi.exceptions;

import com.example.authapi.exceptions.generics.GenericException;

public class UsuarioIntegrationException extends GenericException {

    public UsuarioIntegrationException(String mensagem) {
        super(mensagem);
    }

}
