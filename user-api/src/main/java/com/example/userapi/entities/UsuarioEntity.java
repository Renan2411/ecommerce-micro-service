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
import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "USUARIO.SEQ_USUARIO", sequenceName = "USUARIO.SEQ_USUARIO", allocationSize = 1)
@Table(name = "tb_usuario", schema = "usuario")
@Entity
public class UsuarioEntity {

    @Id
    @Column(name = "US_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO.SEQ_USUARIO")
    private Long id;

    @Column(name = "us_nome")
    private String nome;

    @Column(name = "us_cpf")
    private String cpf;

    @Column(name = "us_email")
    private String email;

    @Column(name = "us_login")
    private String login;

    @Column(name = "us_senha")
    private String senha;

    @Column(name = "us_data_nascimento")
    private OffsetDateTime dataNascimento;

}
