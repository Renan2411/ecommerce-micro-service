package com.example.userapi.exceptions;

import com.example.userapi.exceptions.generics.GenericValidationException;

public class CpfJaExistenteException extends GenericValidationException {

    public CpfJaExistenteException(String cpf) {
        super(String.format("O cpf %s já está em uso por outro usuário.", cpf));
    }

}
