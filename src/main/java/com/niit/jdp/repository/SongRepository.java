package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {

    public List<Song> getAll(Connection connection) throws SQLException {

        String readQuery = "SELECT * FROM `jukebox`.`song`;";

        List<Song> songList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {

            ResultSet songResultSet = statement.executeQuery(readQuery);

            while (songResultSet.next()) {
                int songId = songResultSet.getInt("song_id");
                String songName = songResultSet.getString("song_name");
                String artistName = songResultSet.getString("arist_name");
                double duration = songResultSet.getDouble("duration");
                String genre = songResultSet.getString("genre");

                Song song = new Song(songId, songName, artistName, duration, genre);

                songList.add(song);
            }
        }
        return songList;
    }

    public Song searchById(Connection connection, int id) throws SQLException {

        String searchQueryById = "SELECT * FROM `jukebox`.`song` WHERE(`song_id` = ?);";

        Song song = new Song();

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQueryById)) {

            preparedStatement.setInt(1, id);
            ResultSet songResultSet = preparedStatement.executeQuery();

            while (songResultSet.next()) {

                int songId = songResultSet.getInt("song_id");
                String songName = songResultSet.getString("song_name");
                String artistName = songResultSet.getString("artist_name");
                double duration = songResultSet.getDouble("duration");
                String genre = songResultSet.getString("genre");

                song = new Song(songId, songName, artistName, duration, genre);

            }
        }

        return song;
    }

    public Song searchByName(Connection connection, String name) {

        return null;
    }
}
