create database Dbase

create table address (addrId int, street varchar, city varchar, state char(2), zip int, primary key(addrId))

insert into address values (0, '12 MyStreet', 'berkeley', 'CA', '99999')
select *  from address

create table name (first varchar(10), last varchar(10), addrId integer)
insert into name values ('Fred','Flintston','1')
select * from name