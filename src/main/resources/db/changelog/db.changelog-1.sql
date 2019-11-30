-- liquibase formatted sql

-- changeset cintia.afs:1.0 dbms:mysql

CREATE TABLE endereco
(
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    cep varchar(8) NOT NULL DEFAULT '',
    logradouro varchar(255) NOT NULL DEFAULT '',
    numero varchar(45) NOT NULL DEFAULT '',
    estado varchar(255) NOT NULL DEFAULT '',
    cidade varchar(255) NOT NULL DEFAULT '',
    pais varchar(255) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1;

-- changeset cintia.afs:2.0 dbms:mysql
CREATE TABLE empresa
(
    id int(10) unsigned NOT NULL AUTO_INCREMENT,
    vagas int(10) unsigned DEFAULT NULL,
    site varchar(255) NOT NULL DEFAULT '',
    nome varchar(255) NOT NULL DEFAULT '',
    documento varchar(17) NOT NULL DEFAULT '',
    id_endereco int(10) unsigned NOT NULL,
    PRIMARY KEY (id),
    KEY fk_id_endereco_idx (id_endereco),
    CONSTRAINT fk_id_endereco_empresa FOREIGN KEY (id_endereco)
    REFERENCES endereco (id)
        ON DELETE NO ACTION ON UPDATE NO ACTION)
        ENGINE=InnoDB
    DEFAULT CHARSET=latin1;

-- changeset cintia.afs:3.0 dbms:mysql
CREATE TABLE usuario (

id_usuario int(10) unsigned NOT NULL AUTO_INCREMENT,
login varchar(255) NOT NULL DEFAULT '',
senha varchar(255) NOT NULL DEFAULT '',
salario decimal(19,2) NOT NULL DEFAULT 0.00,
nome varchar(255) NOT NULL DEFAULT '',
documento varchar(17) NOT NULL DEFAULT '',
idade int(10) unsigned DEFAULT NULL,
id_empresa int(10) unsigned NOT NULL,
id_endereco int(10) unsigned NOT NULL,
PRIMARY KEY (id_usuario),
KEY fk_id_empresa (id_empresa),
KEY fk_id_endereco_idx (id_endereco),
CONSTRAINT fk_id_endereco
    FOREIGN KEY (id_endereco)
        REFERENCES endereco (id) ON DELETE NO ACTION ON UPDATE NO ACTION)
        ENGINE=InnoDB
    DEFAULT CHARSET=latin1;