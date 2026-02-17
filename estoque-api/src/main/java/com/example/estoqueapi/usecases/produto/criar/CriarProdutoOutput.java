package com.example.estoqueapi.usecases.produto.criar;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@ApiModel(value = "Saída do serviço de criar produto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriarProdutoOutput {

    @ApiModelProperty(value = "Id do produto criado", example = "1")
    private Long id;

    @ApiModelProperty(value = "Nome do produto", example = "Notebook")
    private String nome;

    @ApiModelProperty(value = "Descrição do produto", example = "Notebook i7 16GB")
    private String descricao;

    @ApiModelProperty(value = "Valor do produto", example = "3999.90")
    private BigDecimal valor;

    @ApiModelProperty(value = "Quantidade em estoque", example = "10")
    private Integer quantidade;
}
