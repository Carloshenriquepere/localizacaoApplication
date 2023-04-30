create table tb_cidade(
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
);

insert into tb_cidade
    (id_cidade, nome, qtd_habitantes)
values
    (1, 'São Paulo', 12396372),
    (2, 'Rio de Janeiro', 10000000),
    (3, 'Fortaleza', 8000000),
    (4, 'Salvador', 7000000),
    (5, 'Belo Horizonte', 6000000),
    (6, 'Porto Alegre', 5000000),
    (7, 'Porto Velho', 40000),
    (8, 'Palmas', 3000),
    (9, 'Recife', 2000000),
    (10, 'Natal', 10000000),
    (11, 'Brasilia', 1212121212),
    (12, 'Vitoria', null),
    (13, 'Santa Catarina', null)
    ;