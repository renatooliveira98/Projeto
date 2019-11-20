-- CONSULTA RETORNE OS ROTEIROS
SELECT * FROM banco_roteiro.roteiros;

-- CONSULTA DE PONTOS
SELECT * FROM banco_roteiro.pontos;

-- CONSULTAR PROGRAMACAO
SELECT programacao.id, programacao.dia, programacao.hora_ida, programacao.hora_volta, motoristas.nome, onibus.placa, roteiros.codigo
FROM programacao inner join motoristas inner join onibus inner join roteiros
on programacao.id_motorista=motoristas.id and programacao.id_onibus=onibus.id and programacao.id_roteiro=roteiros.id;

-- CONSULTAR PROGRAMACAO DE UM DETERMINADO ROTEIRO
SELECT programacao.id, programacao.dia, programacao.hora_ida, programacao.hora_volta, motoristas.nome, onibus.placa, roteiros.codigo
FROM programacao inner join motoristas inner join onibus inner join roteiros
on programacao.id_motorista=motoristas.id and programacao.id_onibus=onibus.id and programacao.id_roteiro=roteiros.id where id_roteiro=1;

-- CONSULTAR CADA PONTO Q CADA ROTEIRO PASSA
SELECT roteiros.codigo, pontos.descricao FROM pontos inner join roteiros inner join roteiro_ponto as rp
on pontos.id=  rp.id_ponto and roteiros.id = rp.id_roteiro;

-- CONSULTAR PONTOS DE UM DETERMINADO ROTEIRO 
SELECT roteiros.codigo, pontos.descricao FROM pontos inner join roteiros inner join roteiro_ponto as rp
on pontos.id=  rp.id_ponto and roteiros.id = rp.id_roteiro
where roteiros.id=1;
