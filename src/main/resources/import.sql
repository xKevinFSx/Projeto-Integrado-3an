-- para usar o arquivo, ir no diretório do mesmo, dentro de resources no projeto (dentro do terminal) 
-- e inserir a seguinte linha: --> mysql -u root -p projeto_integrado < import.sql <--

INSERT INTO tipo_de_arquivo VALUES (NULL, 'Imagem');
INSERT INTO tipo_de_arquivo VALUES (NULL, 'Video');
INSERT INTO tipo_de_arquivo VALUES (NULL, 'Audio');
INSERT INTO tipo_de_arquivo VALUES (NULL, 'Texto');
INSERT INTO tipo_de_arquivo VALUES (NULL, 'Streaming');

INSERT INTO extensao_arquivo VALUES (NULL, 'jpg', 1);
INSERT INTO extensao_arquivo VALUES (NULL, 'jpeg', 1);
INSERT INTO extensao_arquivo VALUES (NULL, 'png', 1);
INSERT INTO extensao_arquivo VALUES (NULL, 'gif', 1);
INSERT INTO extensao_arquivo VALUES (NULL, 'avi', 2);
INSERT INTO extensao_arquivo VALUES (NULL, 'wmv', 2);
INSERT INTO extensao_arquivo VALUES (NULL, 'mp4', 2);
INSERT INTO extensao_arquivo VALUES (NULL, 'mp3', 3);
INSERT INTO extensao_arquivo VALUES (NULL, 'wav', 3);
INSERT INTO extensao_arquivo VALUES (NULL, 'aac', 3);
INSERT INTO extensao_arquivo VALUES (NULL, 'txt', 4);
INSERT INTO extensao_arquivo VALUES (NULL, 'streaming', 5);

INSERT INTO categoria VALUES (1, 'Esporte');
INSERT INTO categoria VALUES (2, 'Tecnologia');
INSERT INTO categoria VALUES (3, 'Politica');
INSERT INTO categoria VALUES (4, 'Educação');

INSERT INTO tag VALUES (NULL, 'Google');
INSERT INTO tag VALUES (NULL, 'Facebook');
INSERT INTO tag VALUES (NULL, 'Youtube');
INSERT INTO tag VALUES (NULL, 'Futebol');
INSERT INTO tag VALUES (NULL, 'Basquete');
INSERT INTO tag VALUES (NULL, 'Eleições');
INSERT INTO tag VALUES (NULL, 'Português');
INSERT INTO tag VALUES (NULL, 'Matematica');
