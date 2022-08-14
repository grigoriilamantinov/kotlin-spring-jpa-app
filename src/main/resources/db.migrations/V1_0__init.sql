create table if not exists users
(
    id              serial,
    email           varchar not null,
    last_name     varchar not null,
    first_name      varchar not null,
    middle_name      varchar,
    phone           varchar not null
);

create unique index if not exists cars_id_uindex
    on users (id);