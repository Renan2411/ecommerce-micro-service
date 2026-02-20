package org.example.gateway.exceptions;


import org.example.gateway.exceptions.generics.GenericValidationException;

public class ConvercaoJsonException extends GenericValidationException {

    public ConvercaoJsonException(String mensagem) {
        super(mensagem);
    }

}
