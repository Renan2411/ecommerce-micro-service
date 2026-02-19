package com.example.userapi.usecases.usuario.buscarporcpf;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Set;

@ApiModel(value = "Saída do serviço de buscar usuário por id")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuscarUsuarioPorCpfOutput {

    @ApiModelProperty(value = "Id do usuário criado", example = "1")
    private Long id;

    @ApiModelProperty(value = "Nome do usuário", example = "Renan")
    private String name;

    @ApiModelProperty(value = "Email do usuário", example = "renan@gmail.com")
    private String email;

    @ApiModelProperty(value = "Cpf do usuário", example = "12345")
    private String cpf;

    @ApiModelProperty(value = "Senha criptografada do usuário", example = "12345")
    private String password;

    @ApiModelProperty(value = "Login do usuário", example = "renan.duarte")
    private String login;

    @ApiModelProperty(value = "Data de nascimento do usuário", example = "24-11-2002")
    private OffsetDateTime dataNascimento;

    @ApiModelProperty(value = "Roles do usuário")
    private Set<Roles> roles;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Roles{

        @ApiModelProperty(value = "id da role do usuário")
        private Long id;

        @ApiModelProperty(value = "Nome da role do usuário")
        private String nome;

        @ApiModelProperty(value = "Descrição da role do usuário")
        private String descricao;

    }

}
