CREATE SEQUENCE [usuario].[seq_role]
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE [usuario].[tb_role](
    [rl_id] INTEGER NOT NULL,
    [rl_nome] VARCHAR(50),
    [rl_descricao] VARCHAR(255)
);

ALTER TABLE [usuario].[tb_role] ADD CONSTRAINT [pk_rk_id] PRIMARY KEY ([rl_id]);

ALTER TABLE [usuario].[tb_role] ADD CONSTRAINT [uc_rl_nome] UNIQUE ([rl_nome]);