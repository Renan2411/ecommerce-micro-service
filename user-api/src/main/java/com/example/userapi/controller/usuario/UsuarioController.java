package com.example.userapi.controller.usuario;

import com.example.userapi.usecases.usuario.buscarporid.BuscarUsuarioPorIdOutput;
import com.example.userapi.usecases.usuario.buscarporid.BuscarUsuarioPorIdUseCase;
import com.example.userapi.usecases.usuario.criar.CriarUsuarioInput;
import com.example.userapi.usecases.usuario.criar.CriarUsuarioOutput;
import com.example.userapi.usecases.usuario.criar.CriarUsuarioUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Api(value = "Usuários", tags = "Usuários", description = "Manutenção de Usuários")
@RestController
@Transactional
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuário criado com sucesso"),
            @ApiResponse(code = 400, message = "Entrada inválida"),
    })
    @PostMapping
    public ResponseEntity<CriarUsuarioOutput> criar(@RequestBody CriarUsuarioInput entrada) {
        CriarUsuarioOutput output = criarUsuarioUseCase.executar(entrada);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscarUsuarioPorIdOutput> buscarPorId(@PathVariable("id") Long idUsuario){
        BuscarUsuarioPorIdOutput output = buscarUsuarioPorIdUseCase.executar(idUsuario);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
