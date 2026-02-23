package org.example.gateway.repositories;

import org.example.gateway.entities.RotasPermissionadasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RotasPermissionadasRepository extends JpaRepository<RotasPermissionadasEntity, Long> {

   Optional<RotasPermissionadasEntity> findOneByNomeAplicacao(String nomeAplicacao);

}
