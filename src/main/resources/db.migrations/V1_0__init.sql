CREATE TABLE IF NOT EXISTS users
(
    id              serial,
    email           varchar not null,
    last_name     varchar not null,
    first_name      varchar not null,
    middle_name      varchar,
    phone           varchar not null
);
