package com.niit.jdp.model;

public class Playlist extends Song {

    private int playlistId;
    private String playlistName;

    public Playlist(int songID, String songName, String artistName, double duration, String genre, int playlistId, String playlistName) {
        super(songID, songName, artistName, duration, genre);
        this.playlistId = playlistId;
        this.playlistName = playlistName;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
}
