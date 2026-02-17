package com.example.estoqueapi.usecases.factory.produto;

import com.example.estoqueapi.services.ProdutoService;
import com.example.estoqueapi.usecases.produto.buscarlistagem.BuscarListagemProdutosUseCase;
import com.example.estoqueapi.usecases.produto.buscarlistagem.converter.BuscarListagemProdutosOutputConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class BuscarListagemProdutosUseCaseFactory {

    @Bean
    @DependsOn("criarBuscarListagemProdutosOutputConverter")
    public BuscarListagemProdutosUseCase criarBuscarListagemProdutosUseCase(ProdutoService produtoService,
                                                                            BuscarListagemProdutosOutputConverter outputConverter) {
        return BuscarListagemProdutosUseCase.builder()
                .produtoService(produtoService)
                .outputConverter(outputConverter)
                .build();
    }

    @Bean
    public BuscarListagemProdutosOutputConverter criarBuscarListagemProdutosOutputConverter() {
        return BuscarListagemProdutosOutputConverter.builder().build();
    }

}
