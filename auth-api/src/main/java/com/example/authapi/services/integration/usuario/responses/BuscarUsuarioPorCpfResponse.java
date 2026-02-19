package com.example.authapi.services.integration.usuario.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuscarUsuarioPorCpfResponse {

    private Long id;
    private String name;
    private String password;
    private String cpf;
    private Set<Roles> roles;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Roles {

        private Long id;
        private String nome;
        private String descricao;

    }

}
