package com.example.estoqueapi.usecases.produto.buscarlistagem;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "Saída do serviço de listagem de produtos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuscarListagemProdutosOutput {

    private List<Item> itens;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {

        @ApiModelProperty(value = "Id do produto")
        private Long id;

        @ApiModelProperty(value = "Nome do produto")
        private String nome;

        @ApiModelProperty(value = "Descrição do produto")
        private String descricao;

        @ApiModelProperty(value = "Valor do produto")
        private BigDecimal valor;

        @ApiModelProperty(value = "Valor formatado do produto")
        private String valorFormatado;

    }

}
