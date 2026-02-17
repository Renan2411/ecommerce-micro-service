package com.example.estoqueapi.usecases.produto.buscarlistagem;

import com.example.estoqueapi.entities.ProdutoEntity;
import com.example.estoqueapi.services.ProdutoService;
import com.example.estoqueapi.usecases.produto.buscarlistagem.converter.BuscarListagemProdutosOutputConverter;
import lombok.Builder;

import java.util.List;

@Builder
public class BuscarListagemProdutosUseCase {

    private final ProdutoService produtoService;
    private final BuscarListagemProdutosOutputConverter outputConverter;

    public BuscarListagemProdutosOutput executar() {
        List<ProdutoEntity> produtoEntities = buscarProdutos();

        return outputConverter.converter(produtoEntities);
    }

    private List<ProdutoEntity> buscarProdutos() {
        return produtoService.buscarListagem();
    }

}
