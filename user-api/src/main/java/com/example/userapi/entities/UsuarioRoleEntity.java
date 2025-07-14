package com.example.userapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "USUARIO.SEQ_USUARIO_ROLE", sequenceName = "USUARIO.SEQ_USUARIO_ROLE", allocationSize = 1)
@Entity
@Table(name = "TB_USUARIO_ROLE", schema = "USUARIO")
public class UsuarioRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO.SEQ_USUARIO_ROLE")
    @Column(name = "UR_ID")
    private Long id;

    @JoinColumn(name = "US_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private UsuarioEntity usuarioEntity;

    @JoinColumn(name = "RL_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private RoleEntity roleEntity;

}
