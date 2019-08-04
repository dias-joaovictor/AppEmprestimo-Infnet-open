drop database appfinancas;
create database appfinancas;
use appfinancas;

create table FAVORECIDO(
    id int not null auto_increment primary key,
    nome varchar(40) not null,
    empresa tinyint not null
);

create table CONTA(
    id int not null auto_increment primary key,
    numeroConta varchar(10) not null,
    descricao varchar(100) null,
    dataCriacao date not null,
    dataCancelamento date null,
    favorecidoid int not null,
    foreign key (favorecidoid) references FAVORECIDO(id)
);




