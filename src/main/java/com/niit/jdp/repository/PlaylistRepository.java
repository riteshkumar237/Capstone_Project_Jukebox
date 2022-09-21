package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {

    public boolean createPlaylist(Connection connection, Playlist playlist) throws SQLException {

        String insertQuery = "insert into `jukebox`.`playlist" + "`playlist_id`, `playlist_name`,`song_id`)" + "values (?,?,?)";

        int numberOfRowsAffected;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, playlist.getPlaylistId());
            preparedStatement.setString(2, playlist.getPlaylistName());
            String songList = playlist.toString().trim().replaceAll("\\[\\]", "");
            preparedStatement.setString(3, songList);


            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    public List<Playlist> displayPlaylist(Connection connection) throws SQLException {

        String readQuery = "SELECT * FROM `jukebox`.`playlist`;";

        List<Playlist> playlists = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {

            ResultSet playlistResultSet = statement.executeQuery(readQuery);

            while (playlistResultSet.next()) {

                int playlistId = playlistResultSet.getInt("playlist_id");
                String playlistName = playlistResultSet.getString("playlist_name");


                Playlist playlist = new Playlist(playlistId, playlistName);

                playlists.add(playlist);
            }
        }

        return playlists;
    }
}
