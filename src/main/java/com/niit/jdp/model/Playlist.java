package com.niit.jdp.model;

import java.util.Objects;

public class Playlist {
    private int playlistId;
    private String playlistName;

    private String songList;
    // private List<Song> songList;

    public Playlist() {
    }

    public Playlist(int playlistId, String playlistName, String songList) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.songList = songList;


    }

/*
    public Playlist(int playlistId, String playlistName, String songList) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.songList = songList;
    }*/

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

    /*public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }*/

    public String getSongList() {
        return songList;
    }

    public void setSongList(String songList) {
        this.songList = songList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playlist)) return false;
        Playlist playlist = (Playlist) o;
        return playlistId == playlist.playlistId && Objects.equals(playlistName, playlist.playlistName) && Objects.equals(songList, playlist.songList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, playlistName, songList);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId=" + playlistId +
                ", playlistName='" + playlistName + '\'' +
                ", songList=" + songList +
                '}';
    }
}
