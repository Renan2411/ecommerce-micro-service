package com.example.userapi.repositories;

import com.example.userapi.entities.UsuarioRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRoleRepository extends JpaRepository<UsuarioRoleEntity, Long> {

    List<UsuarioRoleEntity> findAllByUsuarioEntityId(Long idUsuario);

}
