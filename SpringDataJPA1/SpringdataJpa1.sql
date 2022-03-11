create database demo;
use demo;
create table employee(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20),
age int,
location varchar(20)
)
select * from employee;