INSERT INTO [usuario].[tb_role] (rl_id, rl_nome, rl_descricao)
SELECT NEXT VALUE FOR usuario.seq_role,
       'ADMIN',
       'Permissão de Administrador' WHERE NOT EXISTS (
SELECT 1 FROM [usuario].[tb_role]
    WHERE rl_nome = 'ADMIN'
);

INSERT INTO [usuario].[tb_role] (rl_id, rl_nome, rl_descricao)
SELECT NEXT VALUE FOR usuario.seq_role,
       'CLIENTE',
       'Permissão de Administrador' WHERE NOT EXISTS (
SELECT 1 FROM [usuario].[tb_role]
    WHERE rl_nome = 'CLIENTE'
);

INSERT INTO [usuario].[tb_role] (rl_id, rl_nome, rl_descricao)
SELECT NEXT VALUE FOR usuario.seq_role,
       'FUNCIONARIO',
       'Permissão de Administrador' WHERE NOT EXISTS (
SELECT 1 FROM [usuario].[tb_role]
    WHERE rl_nome = 'FUNCIONARIO'
);