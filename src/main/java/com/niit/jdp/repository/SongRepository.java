package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository implements Repository {

    @Override
    public List<Song> getAll(Connection connection) throws SQLException {

        String readQuery = "SELECT * FROM `jukebox`.`song`;";

        List<Song> songList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {

            ResultSet songResultSet = statement.executeQuery(readQuery);

            while (songResultSet.next()) {

                songList.add(new Song(songResultSet.getInt(1), songResultSet.getString(2), songResultSet.getString(3), songResultSet.getString(4), songResultSet.getDouble(5), songResultSet.getString(6)));
            }
        }
        return songList;
    }

    @Override
    public List<Song> searchById(Connection connection, int id) throws SQLException {
        String searchQueryById = "SELECT * FROM `jukebox`.`song` WHERE(`song_id` = ?);";

        List<Song> songList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQueryById)) {

            preparedStatement.setInt(1, id);
            ResultSet songResultSet = preparedStatement.executeQuery();

            while (songResultSet.next()) {

                songList.add(new Song(songResultSet.getInt(1), songResultSet.getString(2), songResultSet.getString(3), songResultSet.getString(4), songResultSet.getDouble(5), songResultSet.getString(6)));
            }
        }

        return songList;
    }

    @Override
    public List<Song> searchByName(Connection connection, String name) throws SQLException {
        String searchQueryByName = "SELECT * FROM `jukebox`.`song` WHERE(`song_name` = ?);";

        List<Song> songList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQueryByName)) {

            preparedStatement.setString(1, name);
            ResultSet songResultSet = preparedStatement.executeQuery();

            while (songResultSet.next()) {

                songList.add(new Song(songResultSet.getInt(1), songResultSet.getString(2), songResultSet.getString(3), songResultSet.getString(4), songResultSet.getDouble(5), songResultSet.getString(6)));
            }
        }
        return songList;
    }

    @Override
    public List<Song> searchByArtist(Connection connection, String name) throws SQLException {
        String searchQueryByName = "SELECT * FROM `jukebox`.`song` WHERE(`artist_name` = ?);";

        List<Song> songList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQueryByName)) {

            preparedStatement.setString(1, name);
            ResultSet songResultSet = preparedStatement.executeQuery();

            while (songResultSet.next()) {

                songList.add(new Song(songResultSet.getInt(1), songResultSet.getString(2), songResultSet.getString(3), songResultSet.getString(4), songResultSet.getDouble(5), songResultSet.getString(6)));
            }
        }
        return songList;
    }
}
