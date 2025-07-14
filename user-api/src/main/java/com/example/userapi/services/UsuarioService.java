package com.example.userapi.services;

import com.example.userapi.entities.UsuarioEntity;
import com.example.userapi.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioEntity criar(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    public boolean existePorCpf(String cpf){
        return usuarioRepository.existsByCpf(cpf);
    }

    public Optional<UsuarioEntity> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

}
