package com.example.userapi.exceptions;

import com.example.userapi.exceptions.generics.GenericNotFoundException;

public class UsuarioNaoEncontradoException extends GenericNotFoundException {

    private static final String MENSAGEM_ERRO_POR_CPF = "Usuário de cpf %s não encontrado";
    private static final String MENSAGEM_ERRO_POR_EMAIL = "Usuário de email %s não encontrado";

    public UsuarioNaoEncontradoException(Long id) {
        super(String.format("Usuário de id %d não encontrado", id));
    }

    public UsuarioNaoEncontradoException(String campo, String tipoLogin) {
        super(getErrorMessage(campo, tipoLogin));
    }

    private static String getErrorMessage(String campo, String tipoLogin) {
        if (TipoLogin.EMAIL.name().equals(tipoLogin)) {
            return String.format(MENSAGEM_ERRO_POR_EMAIL, campo);
        }
        return String.format(MENSAGEM_ERRO_POR_CPF, campo);
    }

    public enum TipoLogin {
        EMAIL,
        CPF
    }

}
