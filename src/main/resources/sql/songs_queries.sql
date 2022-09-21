-- write query to created a database

create database if not exists `jukebox`;

-- write query to created table

create table if not exists `jukebox`.`song`
(
song_id int not null primary key auto_increment,
song_name varchar(100) not null,
artist_name varchar(100) not null,
duration double not null,
genre varchar(30) not null
);