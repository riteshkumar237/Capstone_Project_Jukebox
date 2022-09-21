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
}
