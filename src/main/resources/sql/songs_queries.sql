-- write query to created a database

create database if not exists `jukebox`;

-- write query to created table

create table if not exists `jukebox`.`song`
(
song_id int not null primary key auto_increment,
song_name varchar(100) not null,
song_path varchar(1000) not null,
artist_name varchar(100) not null,
duration double not null,
genre varchar(30) not null
);

-- write query to insert value in the table.

INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `artist_name`, `duration`, `genre`) VALUES ('1', 'Taare Zameen Par', 'C:\\Users\\rites\\IdeaProjects\\Capstone_Project_Jukebox\\src\\main\\resources\\song\\Taare Zameen Par.wav','Shankar Mahadevan', '7.13', 'Drama');

INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `song_path`, `artist_name`, `duration`) VALUES ('2', 'Bheed Mein Tanhai Mein', 'C:\\Users\\rites\\IdeaProjects\\Capstone_Project_Jukebox\\src\\main\\resources\\song\\Bheed Mein Tanhai Mein.wav', 'Udit Narayan', '6.00', 'Sad');

INSERT INTO `jukebox`.`song` (`song_name`, `song_path`, `artist_name`, `duration`, `genre`) VALUES ('Hum Tumko Nigahon Mein', 'C:\\Users\\rites\\IdeaProjects\\Capstone_Project_Jukebox\\src\\main\\resources\\song\\Hum Tumko Nigahon Mein.wav', 'Udit Narayan', '6.03', 'Pop');

INSERT INTO `jukebox`.`song` (`song_name`, `song_path`, `artist_name`, `duration`, `genre`) VALUES ('Rok Sako To Rok Lo', 'C:\\Users\\rites\\IdeaProjects\\Capstone_Project_Jukebox\\src\\main\\resources\\song\\Rok Sako To Rok Lo.wav', 'Shaan', '4.42', 'Comedy');

INSERT INTO `jukebox`.`song` (`song_name`, `song_path`, `artist_name`, `duration`, `genre`) VALUES ('Sapna Koi', 'C:\\Users\\rites\\IdeaProjects\\Capstone_Project_Jukebox\\src\\main\\resources\\song\\Sapna Koi.wav', 'Asha Bhosle', '3.39', 'Drama');

