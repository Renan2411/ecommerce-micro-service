CREATE SEQUENCE [usuario].[seq_usuario]
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE [usuario].[tb_usuario](
    [us_id] INTEGER NOT NULL,
    [us_nome] VARCHAR(100),
    [us_cpf] VARCHAR(100),
    [us_email] VARCHAR(100),
    [us_login] VARCHAR(100),
    [us_senha] VARCHAR (100),
    [us_data_nascimento] DATETIME2(6)
);

ALTER TABLE [usuario].[tb_usuario] ADD CONSTRAINT [pk_us_id] PRIMARY KEY ([us_id]);

ALTER TABLE [usuario].[tb_usuario] ADD CONSTRAINT [uc_us_email] UNIQUE ([us_email]);

ALTER TABLE [usuario].[tb_usuario] ADD CONSTRAINT [uc_us_cpf] UNIQUE ([us_cpf]);