CREATE TABLE IF NOT EXISTS users
(
    id       serial primary key,
    firstname     varchar(50),
    lastname varchar(30),
    username varchar(30),
    password varchar(30)
    );