CREATE SEQUENCE [usuario].[seq_usuario_role]
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE [usuario].[tb_usuario_role](
    [ur_id] INTEGER NOT NULL,
    [us_id] INTEGER NOT NULL,
    [rl_id] INTEGER NOT NULL
);

ALTER TABLE [usuario].[tb_usuario_role] ADD CONSTRAINT [pk_ur_id] PRIMARY KEY ([ur_id]);

ALTER TABLE [usuario].[tb_usuario_role] ADD CONSTRAINT [fk_us_id] FOREIGN KEY ([us_id]) REFERENCES [usuario].[tb_usuario] ([us_id]);

ALTER TABLE [usuario].[tb_usuario_role] ADD CONSTRAINT [fk_rl_id] FOREIGN KEY ([rl_id]) REFERENCES [usuario].[tb_role] ([rl_id]);