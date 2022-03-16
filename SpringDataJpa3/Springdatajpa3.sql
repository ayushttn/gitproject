create database jpa3;
use jpa3;

#onetoone
create table authors(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20),
streetNumber varchar(20),
location varchar(20),
state varchar(20)
)

create table books(
id int PRIMARY KEY AUTO_INCREMENT,
author_id int,
bookName varchar(50),
FOREIGN KEY (author_id)
REFERENCES authors(id)
)

select * from authors;
select * from books;
delete from authors where id = 1;


#onetomany
create table author1(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20),
streetNumber varchar(20),
location varchar(20),
state varchar(20)
)

create table books1(
id int PRIMARY KEY AUTO_INCREMENT,
author_id int,
bookName varchar(50),
FOREIGN KEY (author_id)
REFERENCES author1(id)
)

select * from author1;
select * from books1;

#manytomany
create table author2(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20),
streetNumber varchar(20),
location varchar(20),
state varchar(20)
)

create table books2(
id int PRIMARY KEY AUTO_INCREMENT,
bookName varchar(50)
)

create table author_book(
author_id int,
book_id int,
FOREIGN KEY (author_id)
REFERENCES author2(id),
FOREIGN KEY (book_id)
REFERENCES books2(id)
)

select * from author2;
select * from books2;
select * from author_book;

