-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE customer
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);
insert into customer(first_name, last_name)
values ('John', 'Smith');
insert into customer(first_name, last_name)
values ('Jane', 'Smith');
insert into customer(first_name, last_name)
values ('John', 'Doe');
insert into customer(first_name, last_name)
values ('Jane', 'Doe');
