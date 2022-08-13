create table if not exists users
(
    id              serial,
    email           varchar not null,
    second_name     varchar not null,
    first_name      varchar not null,
    patronymic      varchar,
    phone           varchar not null
);

create unique index cars_id_uindex
    on users (id);