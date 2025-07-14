package com.example.userapi.services;

import com.example.userapi.entities.RoleEntity;
import com.example.userapi.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Optional<RoleEntity> buscarPorNome(String nome){
        return roleRepository.findByNome(nome);
    }

}
