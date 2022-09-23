package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SongRepositoryTest {

    SongRepository songRepository;
    Connection connection;

    DatabaseService databaseService = new DatabaseService();


    @BeforeEach
    void setUp() throws SQLException {

        songRepository = new SongRepository();

        databaseService.connect();

        connection = databaseService.getConnection();

    }

    @AfterEach
    void tearDown() {
        songRepository = null;
    }

    @Test
    void givenNameShouldShowOneNumberOfSong() throws SQLException {

        String songName = "Taare Zameen Par";

        List<Song> songList = songRepository.searchByName(connection, songName);

        assertEquals(1, songList.size());

    }

    @Test
    void givenNameShouldNotShowMoreThanOneNumberOfSong() throws SQLException {

        String songName = "Taare Zameen Par";

        List<Song> songList = songRepository.searchByName(connection, songName);

        assertNotEquals(5, songList.size());

    }

    @Test
    void givenIdShouldReturnPath() throws SQLException {

        int songID = 4;
        String pathOfTheSong = songRepository.getPathOfTheSong(connection, songID);
        assertEquals("C:\\Users\\rites\\IdeaProjects\\Capstone_Project_Jukebox\\src\\main\\resources\\song\\Rok Sako To Rok Lo.wav", pathOfTheSong);
    }

    @Test
    void givenIdNotReturnPath() throws SQLException {

        int songId = 5;
        String pathOfTheSong1 = songRepository.getPathOfTheSong(connection, songId);
        assertNotEquals("C:\\\\Users\\\\rites\\\\IdeaProjects\\\\Capstone_Project_Jukebox\\\\src\\\\main\\\\resources\\\\song\\\\Rok Sako To Rok Lo.wav", pathOfTheSong1);
    }
}