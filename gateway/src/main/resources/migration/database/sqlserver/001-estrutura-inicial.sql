CREATE SEQUENCE [permissionamento].[seq_permissoes_rotas]
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE [permissionamento].[tb_permissoes_rotas] (
    [prt_id] INTEGER NOT NULL,
    [prt_nome_aplicacao] VARCHAR(255),
    [prt_permissoes] VARCHAR(5000)
);

ALTER TABLE [permissionamento].[tb_permissoes_rotas] ADD CONSTRAINT [pk_prt_id] PRIMARY KEY ([prt_id]);

ALTER TABLE [permissionamento].[tb_permissoes_rotas] ADD CONSTRAINT [ur_prt_nome_aplicacao] UNIQUE ([prt_nome_aplicacao]);