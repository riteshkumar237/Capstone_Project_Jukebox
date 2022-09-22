package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository {
    List<Song> getAll(Connection connection) throws SQLException;

    List<Song> searchById(Connection connection, int id);

    List<Song> searchByName(Connection connection, String name);

    List<Song> searchByArtist(Connection connection, String name);
}
