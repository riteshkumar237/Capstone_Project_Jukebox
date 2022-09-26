package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistRepository {

    Playlist playList = new Playlist();
    Scanner scanner = new Scanner(System.in);

   /* public boolean add(Connection connection, Playlist playlist) throws SQLException {

        int numberOfRowAffected = 0;

        if (playlist != null) {

            Map<Song, Integer> collect = playList.getSongList().stream().collect(Collectors.toMap(Function.identity(), Song::getSongID));
            String str = collect.values().toString().replaceAll("\\[", "").replace(" ", "");
            String insertQuery = "insert into `jukebox`.`playlist` values(?,?);";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, playList.getPlaylistName());
                preparedStatement.setString(2, str);
                numberOfRowAffected = preparedStatement.executeUpdate();
            }
        }
        return numberOfRowAffected > 0;
    }*/


    public List<Playlist> displayPlaylist(Connection connection) throws SQLException {

        String readQuery = "SELECT * FROM `jukebox`.`playlist`;";

        List<Playlist> playlists = new ArrayList<>();
        ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(readQuery);

            while (resultSet.next()) {

                playlists.add(new Playlist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        }
        return playlists;
    }

    public boolean createPlaylist(Connection connection, Playlist playlist) throws SQLException {

        String insertQuery = "INSERT INTO `jukebox`.`playlist` (`playlist_name`, `song_list`) VALUES (?,?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, playlist.getPlaylistName());
            preparedStatement.setString(2, playlist.getSongList());
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }


}
