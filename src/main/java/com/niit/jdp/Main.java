package com.niit.jdp;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.SongPlayerService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice;


        do {

            System.out.println("===========Welcome to Jukebox===============");
            System.out.println("============================================");
            System.out.println("1. View all song");
            System.out.println("2. View song by Song ID");
            System.out.println("3. View song by Song Name");
            System.out.println("4. View song by Artist Name");
            System.out.println("5. Create new playlist");
            System.out.println("6. View existing play list");
            System.out.println("7. Play a song");
            System.out.println("8. Exit");
            System.out.println("============================================");

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();


            DatabaseService databaseService = new DatabaseService();

            try {
                databaseService.connect();


                SongPlayerService songPlayerService = new SongPlayerService();

                PlaylistRepository playlistRepository = new PlaylistRepository();

                SongRepository songRepository = new SongRepository();

                Song song = new Song();


                Playlist playlist = new Playlist();

                Connection connection = databaseService.getConnection();

                switch (choice) {
                    case 1:
                        List<Song> allSongs = songRepository.getAll(connection);

                        System.out.println("============================================");

                        System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "Genre", "Artist");

                        for (Song songs : allSongs) {
                            System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenre(), songs.getArtistName());

                        }
                        System.out.println("============================================");

                        break;
                    case 2:
                        System.out.println("PLEASE ENTER THE SONG ID YOU WANT TO SEARCH");

                        int songID = scanner.nextInt();

                        List<Song> songsListOfId = songRepository.searchById(connection, songID);

                        System.out.println("=============================================");
                        System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "Genre", "Artist");

                        for (Song songs : songsListOfId) {
                            System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenre(), songs.getArtistName());


                        }

                        System.out.println("=============================================");

                        break;


                    case 3:
                        System.out.println("PLEASE ENTER THE SONG NAME YOU WANT TO SEARCH");

                        scanner.nextLine();

                        String songName = scanner.nextLine();

                        List<Song> songsListOfName = songRepository.searchByName(connection, songName);
                        System.out.println("=============================================");
                        System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "Genre", "Artist");

                        for (Song songs : songsListOfName) {
                            System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenre(), songs.getArtistName());
                        }
                        System.out.println("=============================================");

                        System.out.println("To play song enter song Id");

                        int songId1 = scanner.nextInt();

                        songPlayerService.player(songRepository.getPathOfTheSong(connection, songId1));
                        break;

                    case 4:
                        System.out.println("PLEASE ENTER THE ARTIST NAME YOU WANT TO SEARCH");
                        scanner.nextLine();
                        String artist = scanner.nextLine();

                        List<Song> songsListOfArtist = songRepository.searchByArtist(connection, artist);

                        System.out.println("=============================================");
                        System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "Genre", "Artist");

                        for (Song songs : songsListOfArtist) {
                            System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenre(), songs.getArtistName());
                        }
                        System.out.println("=============================================");


                        break;

                    case 5:

                      /*  List<Song> songList = new ArrayList<>();


                        System.out.println("Enter play list name");

                        playlist.setPlaylistName(scanner.next());

                        int option;

                        do {
                            System.out.println("Enter song id to add or enter 0 to go to main manu");
                            option = scanner.nextInt();

                            for (Song songs : songList) {
                                if (songs.getSongID() == option) {
                                    songList.add(songs);
                                }
                            }

                        } while (option != 0);

                        playlist.setSongList(songList);

                        playlistRepository.add(connection, playlist);*/

                        System.out.println("Enter playlist name :");
                        String playlistName = scanner.next();
                        System.out.println("Enter song id");
                        String songId4 = scanner.next();

                        Playlist playlist1 = new Playlist(0, playlistName, songId4);
                        playlistRepository.createPlaylist(connection, playlist1);


                        break;

                    case 6:
                        List<Playlist> displayPlaylist = playlistRepository.displayPlaylist(connection);

                        System.out.println("============================================");

                        System.out.format("%-10s %-30s %-30s \n", "Playlist ID", "PlaylistName", "Song List");

                        for (Playlist playlist2 : displayPlaylist) {
                            System.out.format("%-10s %-30s %-30s \n", playlist2.getPlaylistId(), playlist2.getPlaylistName(), playlist2.getSongList());

                        }
                        System.out.println("============================================");

                        break;


                    case 7:

                        System.out.println("To play song enter song Id");

                        int songId = scanner.nextInt();

                        songPlayerService.player(songRepository.getPathOfTheSong(connection, songId));

                        break;

                    case 8:

                        System.out.println("Exit");

                        break;

                    default:
                        System.err.println("Invalid choice");

                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        } while (choice != 8);
    }
}