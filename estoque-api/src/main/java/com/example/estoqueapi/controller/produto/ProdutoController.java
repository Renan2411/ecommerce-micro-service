package com.example.estoqueapi.controller.produto;

import com.example.estoqueapi.usecases.produto.buscarlistagem.BuscarListagemProdutosOutput;
import com.example.estoqueapi.usecases.produto.buscarlistagem.BuscarListagemProdutosUseCase;
import com.example.estoqueapi.usecases.produto.criar.CriarProdutoInput;
import com.example.estoqueapi.usecases.produto.criar.CriarProdutoOutput;
import com.example.estoqueapi.usecases.produto.criar.CriarProdutoUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Api(value = "Produtos", tags = "Produtos", description = "Manutenção de Produtos")
@RestController
@Transactional
@AllArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final CriarProdutoUseCase criarProdutoUseCase;
    private final BuscarListagemProdutosUseCase buscarListagemProdutosUseCase;

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Produto criado com sucesso"),
            @ApiResponse(code = 400, message = "Entrada inválida"),
    })
    @PostMapping
    public ResponseEntity<CriarProdutoOutput> criar(@RequestBody CriarProdutoInput entrada) {
        CriarProdutoOutput output = criarProdutoUseCase.executar(entrada);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Sucesso ao buscar listagem de produtos"),
            @ApiResponse(code = 400, message = "Entrada inválida"),
    })
    @GetMapping
    public ResponseEntity<BuscarListagemProdutosOutput> buscarListagem() {
        BuscarListagemProdutosOutput output = buscarListagemProdutosUseCase.executar();
        return new ResponseEntity<>(output, HttpStatus.ACCEPTED);
    }

}
