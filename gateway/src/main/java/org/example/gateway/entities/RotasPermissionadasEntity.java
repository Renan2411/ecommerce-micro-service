package org.example.gateway.entities;

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
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "PERMISSIONAMENTO.seq_permissoes_rotas", sequenceName = "PERMISSIONAMENTO.SEQ_PERMISSOES_ROTAS", allocationSize = 1)
@Entity
@Table(name = "tb_permissoes_rotas", schema = "permissionamento")
public class RotasPermissionadasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISSIONAMENTO.SEQ_PERMISSOES_ROTAS")
    @Column(name = "PRT_ID")
    private Long id;

    @Column(name = "PRT_NOME_APLICACAO")
    private String nomeAplicacao;

    @Column(name = "PRT_PERMISSOES")
    private String permissoes;

}
