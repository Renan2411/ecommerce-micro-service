package com.example.estoqueapi.services;

import com.example.estoqueapi.entities.ProdutoEntity;
import com.example.estoqueapi.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoEntity criar(ProdutoEntity produtoEntity) {
        return produtoRepository.save(produtoEntity);
    }

    public List<ProdutoEntity> buscarListagem() {
        return produtoRepository.findAll();
    }

}
