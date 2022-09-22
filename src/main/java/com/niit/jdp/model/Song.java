package com.niit.jdp.model;

import java.util.Objects;

public class Song {
    private int songID;
    private String songName;
    private String songPath;
    private String artistName;
    private double duration;
    private String genre;

    public Song() {
    }

    public Song(int songID, String songName, String songPath, String artistName, double duration, String genre) {
        this.songID = songID;
        this.songName = songName;
        this.songPath = songPath;
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

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return songID == song.songID && Double.compare(song.duration, duration) == 0 && Objects.equals(songName, song.songName) && Objects.equals(songPath, song.songPath) && Objects.equals(artistName, song.artistName) && Objects.equals(genre, song.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songID, songName, songPath, artistName, duration, genre);
    }

    @Override
    public String toString() {
        return "Song{" +
                "songID=" + songID +
                ", songName='" + songName + '\'' +
                ", songPath='" + songPath + '\'' +
                ", artistName='" + artistName + '\'' +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                '}';
    }
}
