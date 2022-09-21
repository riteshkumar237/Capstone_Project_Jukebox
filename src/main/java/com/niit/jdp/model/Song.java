package com.niit.jdp.model;

public class Song {
    private int songID;
    private String songName;
    private String artistName;
    private double duration;
    private String genre;

    public Song() {
    }

    public Song(int songID, String songName, String artistName, double duration, String genre) {
        this.songID = songID;
        this.songName = songName;
        this.artistName = artistName;
        this.duration = duration;
        this.genre = genre;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
