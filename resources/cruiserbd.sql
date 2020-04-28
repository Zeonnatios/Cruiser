
CREATE DATABASE CRUISERBD;
USE CRUISERBD;

CREATE TABLE LOJA (
loja_id int not null auto_increment,
loja_nome varchar(50) not null,
loja_cidade varchar(50) not null,
loja_telefone varchar(11) not null,
loja_regiao varchar(2) not null,
loja_tipo varchar(6) not null,
PRIMARY KEY (loja_id)
);

CREATE TABLE FUNCIONARIO(
func_id int not null auto_increment,
func_nome varchar(50) not null,
func_email varchar(50) not null,
func_senha varchar(10) not null,
func_cidade varchar(40) not null,
func_departamento varchar(50) not null,
func_status boolean not null,
func_loja_id int not null,
PRIMARY KEY (func_id),
FOREIGN KEY (func_loja_id) REFERENCES LOJA(loja_id)
);

CREATE TABLE CLIENTE(
cli_id int not null auto_increment,
cli_nome varchar(50) not null,
cli_cpf varchar(11) not null unique,
cli_email varchar(50) not null,
PRIMARY KEY (cli_id)
);

CREATE TABLE PRODUTO(
prod_id int not null auto_increment,
prod_nome varchar(50) not null,
prod_qtde int not null,
prod_preco double(10,2) not null,
prod_status boolean not null,
PRIMARY KEY(prod_id)
);

CREATE TABLE VENDA(
venda_id int not null auto_increment,
venda_data date not null,
venda_valor_total double(10,2) not null,
venda_funcionario_id int not null,
venda_cliente_id int not null,
PRIMARY KEY(venda_id),
FOREIGN KEY (venda_funcionario_id) REFERENCES FUNCIONARIO(func_id),
FOREIGN KEY (venda_cliente_id) REFERENCES CLIENTE(cli_id)
);

CREATE TABLE ITENS(
itens_prod_id int not null,
itens_venda_id int not null,
itens_quantidade int not null,
itens_preco_unit double(10,2) not null,
FOREIGN KEY (itens_prod_id) REFERENCES PRODUTO(prod_id),
FOREIGN KEY (itens_venda_id) REFERENCES VENDA(venda_id)
);
select * from funcionario;
