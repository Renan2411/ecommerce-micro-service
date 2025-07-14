package com.example.userapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "USUARIO.SEQ_ROLE", sequenceName = "USUARIO.SEQ_ROLE", allocationSize = 1)
@Entity
@Table(name = "tb_role", schema = "usuario")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO.SEQ_ROLE")
    @Column(name = "RL_ID")
    private Long id;

    @Column(name = "RL_NOME")
    private String nome;

    @Column(name = "RL_DESCRICAO")
    private String descricao;

}
