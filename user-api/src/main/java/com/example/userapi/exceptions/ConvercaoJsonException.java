package com.example.userapi.exceptions;

import com.example.userapi.exceptions.generics.GenericValidationException;

public class ConvercaoJsonException extends GenericValidationException {

    public ConvercaoJsonException(String mensagem) {
        super(mensagem);
    }

}
