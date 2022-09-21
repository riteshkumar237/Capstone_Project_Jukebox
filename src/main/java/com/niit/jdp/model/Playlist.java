package com.niit.jdp.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playlist)) return false;
        if (!super.equals(o)) return false;
        Playlist playlist = (Playlist) o;
        return playlistId == playlist.playlistId && Objects.equals(playlistName, playlist.playlistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), playlistId, playlistName);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId=" + playlistId +
                ", playlistName='" + playlistName + '\'' +
                '}';
    }
}
