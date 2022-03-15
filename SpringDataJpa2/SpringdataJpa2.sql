create database jpa2;
use jpa2;
create table employeeTable(
empid int PRIMARY KEY AUTO_INCREMENT,
empFirstName varchar(20),
empLastName varchar(20),
empSalary double,
empAge int
)
select * from employeeTable;
drop table employeeTable;


create table worker(
id int PRIMARY KEY,
workertype varchar(2),
name varchar(20),
salary decimal(8,3),
pension decimal(8,3)
);
select * from worker;


create table onlineorder(
id int PRIMARY KEY,
name varchar(20),
onlineorderid int
)

select * from onlineorder;

create table codorder(
id int PRIMARY KEY,
name varchar(20),
codorderid int
)

select * from codorder;

create table payment(
id int PRIMARY KEY,
amount decimal(8,3)
);

create table card(
id int ,
cardnumber varchar(20),
 FOREIGN KEY (id)
REFERENCES payment(id)
)

create table bankcheck(
id int ,
checknumber varchar(20),
FOREIGN KEY (id)
REFERENCES payment(id)
)


create table emp(
id int PRIMARY KEY,
firstName varchar(20),
lastName varchar(20),
age int,
basicSalary decimal(8,3),
bonusSalary decimal(8,3),
taxAmount decimal(8,3),
specialAllowanceSalary decimal(8,3)
)
select * from emp;
