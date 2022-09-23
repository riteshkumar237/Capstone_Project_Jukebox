package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {

    public boolean createPlaylist(Connection connection, Playlist playlist) throws SQLException {

        String insertQuery = "insert into `jukebox`.`playlist" + " `playlist_name`,`song_list`)" + "values (?,?)";

        int numberOfRowsAffected;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, playlist.getPlaylistName());
            String songList = playlist.toString().trim().replaceAll("\\[\\]", "");
            preparedStatement.setString(2, songList);


            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    public List<Playlist> exitingPlaylist(Connection connection) throws SQLException {

        String readQuery = "SELECT * FROM `jukebox`.`playlist`;";

        List<Playlist> playlists = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(readQuery, Statement.RETURN_GENERATED_KEYS)) {

            ResultSet playlistResultSet = preparedStatement.executeQuery();

            while (playlistResultSet.next()) {

                int playlistId = playlistResultSet.getInt("playlist_id");

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

                while (generatedKeys.next()) {

                    int id = generatedKeys.getInt("playlist_id");
                }
                String playlistName = playlistResultSet.getString("playlist_name");


                String songList = playlistResultSet.getString("songList");

                songList = playlists.toString().trim().replaceAll("\\[\\]", "");

                String[] songId = songList.split(",");

                for (String songName : songId) {
                    SongRepository songRepository = new SongRepository();
                    List<Song> song = songRepository.searchById(connection, playlistId);

                }

            }
        }

        return playlists;
    }


}
