drop  database financeiro; create database financeiro; use financeiro;
CREATE TABLE favorecido(
	id_favorecido INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    data_canacelamennto DATE,
    is_empresa BIT,
    nome NVARCHAR(256)
);

CREATE TABLE conta(
	id_conta INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    valor FLOAT NOT NULL DEFAULT 0,
    data_criacao DATE,
    data_cancelamento DATE,
    descricao TEXT,
    numero_conta INT NOT NULL,
    id_favorecido INT NOT NULL,
    CONSTRAINT fk_conta_favorecido
		FOREIGN KEY (id_favorecido)
        REFERENCES favorecido(id_favorecido)
);

CREATE TABLE emprestimo(
	id_emprestimo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    valor FLOAT,
    data_criacao DATE,
    quant_parcelas INT,
    porcent_juros FLOAT,
    tipo_periodo INT,
    id_conta INT NOT NULL,
    CONSTRAINT fk_Emprestimo_conta
		FOREIGN KEY (id_conta)
        REFERENCES conta(id_conta)
);

CREATE TABLE penhor(
	id_penhor INT PRIMARY KEY NOT NULL,
    CONSTRAINT fk_Penhor_Emprestimo
		FOREIGN KEY (id_penhor)
        REFERENCES emprestimo(id_emprestimo),
    bem_penhorado NVARCHAR(256) NOT NULL,
    is_tradicional BIT NOT NULL DEFAULT 1
);

CREATE TABLE refinanciamento_imovel(
	id_refinanciamento_imovel INT PRIMARY KEY NOT NULL,
    CONSTRAINT fk_Refinanciamento_Emprestimo
		FOREIGN KEY (id_refinanciamento_imovel)
        REFERENCES emprestimo(id_emprestimo),
    endereco_residencia NVARCHAR(1024),
    num_matricula_registro INT NOT NULL
);

CREATE TABLE pessoal(
	id_pessoal INT PRIMARY KEY NOT NULL,
    CONSTRAINT fk_Pessoal_Emprestimo
		FOREIGN KEY (id_pessoal)
        REFERENCES emprestimo(id_emprestimo),
	status_aprovacao NVARCHAR(20) NOT NULL
);


create table usuario(
	id_usuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome NVARCHAR(256) NOT NULL,
	email NVARCHAR(256) NOT NULL,
	senha NVARCHAR(256) NOT NULL
);
