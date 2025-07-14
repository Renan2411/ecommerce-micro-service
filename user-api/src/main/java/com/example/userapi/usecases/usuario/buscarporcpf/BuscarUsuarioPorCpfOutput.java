package com.example.userapi.usecases.usuario.buscarporcpf;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@ApiModel(value = "Saída do serviço de buscar usuário por id")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuscarUsuarioPorCpfOutput {

    @ApiModelProperty(value = "Id do usuário criado", example = "1")
    private Long id;

    @ApiModelProperty(value = "Nome do usuário", example = "Renan")
    private String nome;

    @ApiModelProperty(value = "Email do usuário", example = "renan@gmail.com")
    private String email;

    @ApiModelProperty(value = "Cpf do usuário", example = "12345")
    private String cpf;

    @ApiModelProperty(value = "Login do usuário", example = "renan.duarte")
    private String login;

    @ApiModelProperty(value = "Data de nascimento do usuário", example = "24-11-2002")
    private OffsetDateTime dataNascimento;

}
