package com.example.userapi.services;

import com.example.userapi.entities.UsuarioRoleEntity;
import com.example.userapi.repositories.UsuarioRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioRoleService {

    private final UsuarioRoleRepository usuarioRoleRepository;

    public UsuarioRoleEntity criar(UsuarioRoleEntity usuarioRoleEntity) {
        return usuarioRoleRepository.save(usuarioRoleEntity);
    }

    public List<UsuarioRoleEntity> buscarListagemPorIdUsuario(Long idUsuario) {
        return usuarioRoleRepository.findAllByUsuarioEntityId(idUsuario);
    }

}
