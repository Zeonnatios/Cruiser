DROP DATABASE CRUISERBD;
CREATE DATABASE CRUISERBD;
USE CRUISERBD;

CREATE TABLE LOJA (
loja_id int not null auto_increment,
loja_cidade varchar(50) not null,
loja_telefone varchar(11) not null unique,
loja_tipo varchar(6) not null,
PRIMARY KEY (loja_id)
);

CREATE TABLE FUNCIONARIO(
func_id int not null auto_increment,
func_nome varchar(50) not null,
func_email varchar(50) not null unique,
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
cli_email varchar(50) not null unique,
PRIMARY KEY (cli_id)
);

CREATE TABLE PRODUTO(
prod_id int not null auto_increment,
prod_nome varchar(50) not null,
prod_qtde int not null,
prod_preco double(10,2) not null,
prod_status boolean not null,
prod_loja_id int not null,
PRIMARY KEY(prod_id),
FOREIGN KEY (prod_loja_id) REFERENCES LOJA(loja_id)
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

INSERT INTO `LOJA` (`loja_id`, `loja_cidade`, `loja_telefone`, `loja_tipo`) 
VALUES ('1', 'Sao Paulo', '11234567890', 'Matriz'),
('2', 'Campina Grande', '83123456789', 'Filial'),
('3', 'Joinville', '31135795539', 'Filial'), 
('4', 'Distrito Federal', '61987654321', 'Filial');

INSERT INTO `FUNCIONARIO` (`func_id`, `func_nome`, `func_email`, `func_senha`, `func_cidade`, `func_departamento`, `func_status`, `func_loja_id`) 
VALUES ('1', 'Matheus Antonio da Silva', 'matheusantonio232@gmail.com', 'asd', 'Sao Paulo', 'Tecnologia', '1', '1'), 
('2', 'Raphaela Wagner', 'ellaw@uol.com.br', 'asd', 'Sao Paulo', 'Tecnologia', '1', '1'), 
('3', 'Luis Eduardo', 'louroconrado@gmail.com', 'asd', 'Sao Paulo', 'Tecnologia', '1', '1'), 
('4', 'Lukas Matias', 'lukaskt6@gmail.com', 'asd', 'Sao Paulo', 'Tecnologia', '1', '1');

INSERT INTO `CLIENTE` (`cli_id`, `cli_nome`, `cli_cpf`, `cli_email`) 
VALUES ('1', 'Jorge', '12345678910', 'jorge@teste.com');

INSERT INTO `PRODUTO`(`prod_id`, `prod_nome`, `prod_qtde`, `prod_preco`, `prod_status`, `prod_loja_id`) 
VALUES ('1', 'Skate Cruiser', '50', '540.00', '1', '1'), 
('2', 'Rolamento T5', '150', '29.90', '1', '1'), 
('3', 'Skate Street', '300', '450.00', '1', '1');