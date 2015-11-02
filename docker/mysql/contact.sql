create database if not exists `contact` default character set latin1 collate latin1_swedish_ci;
use `contact`;


create table contacts (
    id bigint AUTO_INCREMENT,
    email varchar(255),
    name varchar(255),
    user_id bigint,
    uuid  varchar(255),
    primary key (id)
);

create table users (
    id bigint AUTO_INCREMENT,
    passwd varchar(255),
    username varchar(255),
    permissions varchar(255),
    uuid  varchar(255),
    primary key (id)
);

alter table contacts add constraint FK_contacts_users foreign key (user_id) references users;


INSERT INTO  `users` (`id`, `username`, `passwd`, `permissions`, `uuid`) VALUES
( 0,'q', 'q', 'USER', '2347'),
( 1,'robbert', 'robbert', 'USER,ADMIN', '2345'),
( 2,'john', 'pw', 'USER', '2346');

INSERT INTO `contacts` ( `id`, `user_id`, `name`, `email`, `UUID`) VALUES
( 0,1, 'john', 'john@gmail.com', '1234'),
( 1,1, 'cindy', 'cindy@gmail.com', '1235'),
( 2,0, 'pieter', 'peter@gmail.com', '1236'),
( 3,2, 'ray', 'ray@gmail.com', '1237'),
( 4,2, 'jack', 'jack@gmail.com', '1238'),
( 5,2, 'sil', 'sil@gmail.com', '1239');



