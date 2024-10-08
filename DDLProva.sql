use spring;

create table alt_alerta(
    alt_id bigint primary key auto_increment,
    alt_mensagem varchar(100) not null,
    alt_detalhe varchar(255),
    alt_data_hora_geracao datetime not null,
    alt_data_hora_verificacao datetime,
    alt_nivel int
);

insert into alt_alerta(alt_mensagem, alt_data_hora_geracao, alt_nivel)
    values ('Estouro de memória', '2024-03-15 23:59:59', 1),
            ('Estouro em disco', current_timestamp(), null)