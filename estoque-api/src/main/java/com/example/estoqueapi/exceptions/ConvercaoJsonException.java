package com.example.estoqueapi.exceptions;

import com.example.estoqueapi.exceptions.generics.GenericValidationException;

public class ConvercaoJsonException extends GenericValidationException {

    public ConvercaoJsonException(String mensagem) {
        super(mensagem);
    }

}
