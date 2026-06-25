CREATE TABLE candidatos
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    nome            VARCHAR(255) NULL,
    cpf             VARCHAR(20) NOT NULL UNIQUE,
    sexo            VARCHAR(255) NULL,
    estado          VARCHAR(255) NULL,
    altura DOUBLE NULL,
    peso DOUBLE NULL,
    tipo_sanguineo  VARCHAR(255) NULL,
    data_nascimento date NULL,
    CONSTRAINT pk_candidatos PRIMARY KEY (id)
);