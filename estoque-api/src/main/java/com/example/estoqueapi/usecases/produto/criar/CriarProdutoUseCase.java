package com.example.estoqueapi.usecases.produto.criar;

import com.example.estoqueapi.entities.ProdutoEntity;
import com.example.estoqueapi.services.ProdutoService;
import com.example.estoqueapi.usecases.produto.criar.converter.CriarProdutoOutputConverter;
import com.example.estoqueapi.utils.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Objects;

@Builder
@AllArgsConstructor
public class CriarProdutoUseCase {

    private final ProdutoService produtoService;
    private final CriarProdutoOutputConverter outputConverter;

    public CriarProdutoOutput executar(CriarProdutoInput entrada) {
        validarEntrada(entrada);

        ProdutoEntity produtoEntity = criarProdutoEntity(entrada);
        produtoEntity = salvarProduto(produtoEntity);

        return outputConverter.converter(produtoEntity);
    }

    private void validarEntrada(CriarProdutoInput entrada) {
        Validator.of(entrada)
                .validate(Objects.nonNull(entrada.getNome()), "Ausência do nome do produto")
                .validate(Objects.nonNull(entrada.getDescricao()), "Ausência da descrição do produto")
                .validate(Objects.nonNull(entrada.getValor()), "Ausência do valor do produto")
                .validate(Objects.nonNull(entrada.getQuantidade()), "Ausência da quantidade do produto")
                .get();
    }

    private ProdutoEntity criarProdutoEntity(CriarProdutoInput entrada) {
        return ProdutoEntity.builder()
                .nome(entrada.getNome())
                .descricao(entrada.getDescricao())
                .valor(entrada.getValor())
                .quantidade(entrada.getQuantidade())
                .build();
    }

    private ProdutoEntity salvarProduto(ProdutoEntity produtoEntity) {
        return produtoService.criar(produtoEntity);
    }
}
