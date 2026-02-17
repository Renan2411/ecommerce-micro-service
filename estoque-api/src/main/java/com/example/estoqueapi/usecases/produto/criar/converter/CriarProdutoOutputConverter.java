package com.example.estoqueapi.usecases.produto.criar.converter;

import com.example.estoqueapi.entities.ProdutoEntity;
import com.example.estoqueapi.usecases.produto.criar.CriarProdutoOutput;
import lombok.Builder;

@Builder
public class CriarProdutoOutputConverter {

    public CriarProdutoOutput converter(ProdutoEntity produtoEntity) {
        return CriarProdutoOutput.builder()
                .id(produtoEntity.getId())
                .nome(produtoEntity.getNome())
                .descricao(produtoEntity.getDescricao())
                .valor(produtoEntity.getValor())
                .quantidade(produtoEntity.getQuantidade())
                .build();
    }
}
