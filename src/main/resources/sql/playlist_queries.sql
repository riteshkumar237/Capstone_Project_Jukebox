-- write query to create table playlist

create table if not exists `jukebox`.`playlist`
(
`paylist_id` int not null primary key,
`playlist_name` varchar(100) not null,
`song_id` int not null
);