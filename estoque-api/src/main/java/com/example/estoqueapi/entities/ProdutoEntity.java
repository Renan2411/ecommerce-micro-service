package com.example.estoqueapi.entities;

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
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_PRODUTO", sequenceName = "ESTOQUE.SEQ_PRODUTO", allocationSize = 1)
@Table(name = "tb_produto", schema = "estoque")
@Entity
public class ProdutoEntity {

    @Id
    @Column(name = "PR_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUTO")
    private Long id;

    @Column(name = "PR_NOME")
    private String nome;

    @Column(name = "PR_DESCRICAO")
    private String descricao;

    @Column(name = "PR_VALOR")
    private BigDecimal valor;

    @Column(name = "PR_QUANTIDADE")
    private Integer quantidade;

}
