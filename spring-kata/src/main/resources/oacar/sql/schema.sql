drop table customer if exists;
drop table rental if exists;
create table customer (id integer identity primary key,
name varchar(50), firstname varchar(50), age integer);
create table rental (id integer identity primary key,
carid integer, customerid integer, rented boolean);
