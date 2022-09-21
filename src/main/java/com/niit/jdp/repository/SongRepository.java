package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public Song searchByID(Connection connection, int id) {

        return null;
    }
}
