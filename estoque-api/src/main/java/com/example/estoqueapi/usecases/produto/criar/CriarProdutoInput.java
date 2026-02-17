package com.example.estoqueapi.usecases.produto.criar;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Entrada do serviço de criar produtos")
public class CriarProdutoInput {

    @ApiModelProperty(value = "Nome do produto", example = "Notebook", required = true)
    private String nome;

    @ApiModelProperty(value = "Descrição do produto", example = "Notebook i7 16GB", required = true)
    private String descricao;

    @ApiModelProperty(value = "Valor do produto", example = "3999.90", required = true)
    private BigDecimal valor;

    @ApiModelProperty(value = "Quantidade em estoque", example = "10", required = true)
    private Integer quantidade;
}
