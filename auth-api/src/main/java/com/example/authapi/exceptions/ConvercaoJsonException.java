package com.example.authapi.exceptions;

import com.example.authapi.exceptions.generics.GenericException;

public class ConvercaoJsonException extends GenericException {

    public ConvercaoJsonException(String mensagem) {
        super(mensagem);
    }

}
