package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlaylistRepository {

    Playlist playList = new Playlist();
    Scanner scanner = new Scanner(System.in);

    public boolean add(Connection connection, Playlist playlist) throws SQLException {

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

                    //  playlists.add(song);


                }

            }
        }

        return playlists;
    }


}
