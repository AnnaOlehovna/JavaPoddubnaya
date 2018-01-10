package by.itacademy.task2;

import java.util.ArrayList;

public class Artist {

    private String artistName;
    private ArrayList<Album> albumsList;

    public ArrayList<Album> getAlbumsList() {
        return albumsList;
    }

    public void setAlbumsList(ArrayList<Album> albumsList) {
        this.albumsList = albumsList;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Artist(String artistName) {
        this.artistName = artistName;
    }
}
