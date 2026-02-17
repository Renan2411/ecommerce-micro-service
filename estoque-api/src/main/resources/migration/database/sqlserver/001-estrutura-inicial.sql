CREATE SEQUENCE [estoque].[seq_produto]
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE [estoque].[tb_produto] (
    [pr_id] INTEGER NOT NULL,
    [pr_nome] VARCHAR(255),
    [pr_valor] DECIMAL(11,2),
    [pr_quantidade] INTEGER,
    [pr_descricao] VARCHAR(5000)
);

ALTER TABLE [estoque].[tb_produto] ADD CONSTRAINT [pk_pr_id] PRIMARY KEY ([pr_id]);