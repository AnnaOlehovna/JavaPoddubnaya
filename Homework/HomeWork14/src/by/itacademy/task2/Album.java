package by.itacademy.task2;

import java.util.ArrayList;

public class Album {

    private String albumName;

    private ArrayList<Track> trackList;


    public Album(String albumName) {
        this.albumName = albumName;
    }

    public ArrayList<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(ArrayList<Track> trackList) {
        this.trackList = trackList;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
