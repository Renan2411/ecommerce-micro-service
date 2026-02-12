package com.example.authapi.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleEntity implements Serializable {

    private String id;
    private String nome;
    private String descricao;

}
