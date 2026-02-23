package org.example.gateway.services;

import lombok.AllArgsConstructor;
import org.example.gateway.entities.RotasPermissionadasEntity;
import org.example.gateway.repositories.RotasPermissionadasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RotasPermissionadasService {

    private final RotasPermissionadasRepository rotasPermissionadasRepository;

    public RotasPermissionadasEntity criar(RotasPermissionadasEntity rotasPermissionadas) {
        return rotasPermissionadasRepository.save(rotasPermissionadas);
    }

    public RotasPermissionadasEntity editar(RotasPermissionadasEntity rotasPermissionadas) {
        return rotasPermissionadasRepository.save(rotasPermissionadas);
    }

    public Optional<RotasPermissionadasEntity> buscarPorNomeAplicacao(String nomeAplicacao) {
        return rotasPermissionadasRepository.findOneByNomeAplicacao(nomeAplicacao);
    }

    public List<RotasPermissionadasEntity> buscarListagem() {
        return rotasPermissionadasRepository.findAll();
    }

}
