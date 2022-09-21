package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PlaylistRepository {

    public boolean createPlaylist(Connection connection, Playlist playlist) throws SQLException {

        String insertQuery = "insert into `jukebox`.`playlist" + "`playlist_id`, `playlist_name`,`song_id`)" + "values (?,?,?)";

        int numberOfRowsAffected;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, playlist.getPlaylistId());
            preparedStatement.setString(2, playlist.getPlaylistName());
            preparedStatement.setInt(3, playlist.getSongID());

            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    public List<Playlist> displayPlaylist(Connection connection) {

        return null;
    }
}
