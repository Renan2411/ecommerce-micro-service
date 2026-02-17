package com.example.estoqueapi.usecases.factory.produto;

import com.example.estoqueapi.services.ProdutoService;
import com.example.estoqueapi.usecases.produto.criar.CriarProdutoUseCase;
import com.example.estoqueapi.usecases.produto.criar.converter.CriarProdutoOutputConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class CriarProdutoUseCaseFactory {

    @Bean
    @DependsOn("criarProdutoOutputConverter")
    public CriarProdutoUseCase criarProdutoUseCase(ProdutoService produtoService,
                                                   CriarProdutoOutputConverter outputConverter) {
        return CriarProdutoUseCase.builder()
                .produtoService(produtoService)
                .outputConverter(outputConverter)
                .build();
    }

    @Bean
    public CriarProdutoOutputConverter criarProdutoOutputConverter() {
        return CriarProdutoOutputConverter.builder().build();
    }
}
