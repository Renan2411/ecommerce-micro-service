package com.example.userapi.repositories;

import com.example.userapi.entities.UsuarioRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRoleRepository extends JpaRepository<UsuarioRoleEntity, Long> {

}
