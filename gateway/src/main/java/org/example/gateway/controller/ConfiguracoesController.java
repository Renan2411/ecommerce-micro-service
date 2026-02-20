package org.example.gateway.controller;

import org.example.gateway.usecase.configuracoes.permissoes.ConfigurarPermissoesInput;
import org.example.gateway.usecase.configuracoes.permissoes.ConfigurarPermissoesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configuracao")
public class ConfiguracoesController {

    @Autowired
    private ConfigurarPermissoesUseCase configurarPermissoesUseCase;

    @PostMapping("/permissoes")
    public ResponseEntity<Void> executar(@RequestBody ConfigurarPermissoesInput entrada) {
        configurarPermissoesUseCase.executar(entrada);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
