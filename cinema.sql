CREATE TABLE usuarios (
id          		BIGINT (20) NOT NULL AUTO_INCREMENT,
dataHora   			TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
nome        		TEXT NOT NULL,
login       		VARCHAR (50) NOT NULL,
senha      			VARCHAR (50) NOT NULL,
dataNascimento		DATE NOT NULL,
altura				float(10,2) NOT NULL,
CONSTRAINT pk_usuarios PRIMARY KEY(id)) ENGINE = InnoDB COLLATE = latin1_general_ci;

INSERT INTO usuarios (nome ,login, senha, dataNascimento, altura) VALUES ( 'Usuário Aluno Teste','aluno', MD5('123456'),'1982-10-06',1.7);

CREATE TABLE cadastros (
id                  BIGINT (20) NOT NULL AUTO_INCREMENT,
data_hora           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
nome	            VARCHAR (100) NOT NULL,
sexo                CHAR (2) NOT NULL,
descricao			TEXT NOT NULL,
id_cadastro_usuario BIGINT (20) NOT NULL,
CONSTRAINT pk_cadastros PRIMARY KEY(id),
CONSTRAINT fk_cadastros_usuarios FOREIGN KEY(id_cadastro_usuario) REFERENCES usuarios(id)) ENGINE = InnoDB COLLATE = latin1_general_ci;

