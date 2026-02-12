package com.example.authapi.services.integration.usuario.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuscarUsuarioPorCpfResponse {

    private Long id;
    private String nome;
    private String senha;

}
