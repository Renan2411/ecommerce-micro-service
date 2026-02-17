package com.example.estoqueapi.usecases.produto.buscarlistagem.converter;

import com.example.estoqueapi.entities.ProdutoEntity;
import com.example.estoqueapi.usecases.produto.buscarlistagem.BuscarListagemProdutosOutput;
import lombok.Builder;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Builder
public class BuscarListagemProdutosOutputConverter {

    public BuscarListagemProdutosOutput converter(List<ProdutoEntity> produtoEntities) {
        return BuscarListagemProdutosOutput.builder()
                .itens(montarItens(produtoEntities))
                .build();
    }

    private @NonNull List<BuscarListagemProdutosOutput.Item> montarItens(List<ProdutoEntity> produtoEntities) {
        return produtoEntities.stream()
                .map(produto -> BuscarListagemProdutosOutput.Item.builder()
                        .id(produto.getId())
                        .nome(produto.getNome())
                        .descricao(produto.getDescricao())
                        .valor(produto.getValor())
                        .valorFormatado(formatarValor(produto.getValor()))
                        .build())
                .collect(Collectors.toList());
    }

    private String formatarValor(BigDecimal valor) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        numberFormat.setMaximumFractionDigits(2);

        return numberFormat.format(valor).replaceAll("\u00A0", " ");
    }

}
