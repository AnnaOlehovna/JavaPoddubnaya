package by.itacademy.task2;

import com.mpatric.mp3agic.Mp3File;

import java.util.ArrayList;
import java.util.HashMap;

public class CatalogMp3 {

    public HashMap<String, HashMap<String, HashMap<String, ArrayList<String>>>> createCatalogAll(ArrayList<Mp3File> mp3List) {
        HashMap<String, HashMap<String, HashMap<String, ArrayList<String>>>> mp3HashMap = new HashMap<>();

        for (Mp3File mp3File : mp3List) {
            String currentArtist = mp3File.getId3v2Tag().getArtist();
            if (currentArtist == null) {
                currentArtist = "Unknown Artist";
            }
            String currentPath = mp3File.getFilename();

            String currentAlbum = mp3File.getId3v2Tag().getAlbum();
            if (currentAlbum == null) {
                currentAlbum = "Unknown";
            }
            String currentTrack = mp3File.getId3v2Tag().getTitle();
            if (currentTrack == null) {
                currentTrack = "Unknown";
            }

            int lengthSec = (int) mp3File.getLengthInSeconds();
            int lengthMin = lengthSec / 60;


            String currentLong = lengthMin + " мин " + (lengthSec - lengthMin * 60) + " сек";


            if (mp3HashMap.containsKey(currentArtist)) {

                if (mp3HashMap.get(currentArtist).containsKey(currentAlbum)) {

                    ArrayList<String> trackInformation = new ArrayList<>();
                    trackInformation.add(currentLong);
                    trackInformation.add(currentTrack);
                    mp3HashMap.get(currentArtist).get(currentAlbum).put(currentPath, trackInformation);
                } else {
                    HashMap<String, HashMap<String, ArrayList<String>>> albumList = new HashMap<>();
                    HashMap<String, ArrayList<String>> trackList = new HashMap<>();
                    ArrayList<String> trackInformation = new ArrayList<>();
                    trackInformation.add(currentLong);
                    trackInformation.add(currentTrack);
                    trackList.put(currentPath, trackInformation);
                    albumList.put(currentAlbum, trackList);
                    mp3HashMap.get(currentArtist).putAll(albumList);
                }
            } else {
                HashMap<String, HashMap<String, ArrayList<String>>> albumList = new HashMap<>();
                HashMap<String, ArrayList<String>> trackList = new HashMap<>();
                ArrayList<String> trackInformation = new ArrayList<>();
                trackInformation.add(currentLong);
                trackInformation.add(currentTrack);
                trackList.put(currentPath, trackInformation);
                albumList.put(currentAlbum, trackList);
                mp3HashMap.put(currentArtist, albumList);
            }
        }
        return mp3HashMap;
    }

    public void printMyMp3(HashMap<String, HashMap<String, HashMap<String, ArrayList<String>>>> mp3HashMap) {
        for (String artist : mp3HashMap.keySet()) {
            System.out.println("Исполнитель  " + artist);

            for (HashMap.Entry<String, HashMap<String, ArrayList<String>>> entry1 : mp3HashMap.get(artist).entrySet()) {
                System.out.println("    Альбом: " + entry1.getKey());
                for (HashMap.Entry<String, ArrayList<String>> entry2 : entry1.getValue().entrySet()) {
                    System.out.println("          Композиция: " + entry2.getValue().get(1) + " Длительность: " + entry2.getValue().get(0)
                            + " (" + entry2.getKey() + ")");
                }
            }
        }
    }
}



