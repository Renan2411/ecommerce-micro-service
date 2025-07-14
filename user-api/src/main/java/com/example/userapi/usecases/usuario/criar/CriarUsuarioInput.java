package com.example.userapi.usecases.usuario.criar;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@ApiModel(value = "Entrada do serviço de criar usuário")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriarUsuarioInput {

    @ApiModelProperty(value = "Nome do usuário", example = "Renan", required = true)
    private String nome;

    @ApiModelProperty(value = "Email do usuário", example = "renan@gmail.com", required = true)
    private String email;

    @ApiModelProperty(value = "Cpf do usuário", example = "12345", required = true)
    private String cpf;

    @ApiModelProperty(value = "Login do usuário", example = "renan.duarte", required = true)
    private String login;

    @ApiModelProperty(value = "Senha do usuário", example = "senha123", required = true)
    private String senha;

    @ApiModelProperty(value = "Data de nascimento do usuário", example = "24-11-2002", required = true)
    private OffsetDateTime dataNascimento;

}
