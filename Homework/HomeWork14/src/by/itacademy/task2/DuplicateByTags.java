package by.itacademy.task2;

import com.mpatric.mp3agic.Mp3File;

import java.util.ArrayList;
import java.util.HashMap;

public class DuplicateByTags {

    public HashMap<String, HashMap<String, HashMap<String, ArrayList<String>>>> createCatalogNoDuplicate(ArrayList<Mp3File> mp3List) {
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

            if (mp3HashMap.containsKey(currentArtist)) {

                if (mp3HashMap.get(currentArtist).containsKey(currentAlbum)) {
                    if(mp3HashMap.get(currentArtist).get(currentAlbum).containsKey(currentTrack)){
                    mp3HashMap.get(currentArtist).get(currentAlbum).get(currentTrack).add(currentPath);}
                    else{
                        ArrayList<String> trackPaths = new ArrayList<>();
                        trackPaths.add(currentPath);
                        mp3HashMap.get(currentArtist).get(currentAlbum).put(currentTrack,trackPaths);
                    }
                } else {
                    HashMap<String, HashMap<String, ArrayList<String>>> albumList = new HashMap<>();
                    HashMap<String, ArrayList<String>> trackList = new HashMap<>();
                    ArrayList<String> trackPaths = new ArrayList<>();
                    trackPaths.add(currentPath);
                    trackList.put(currentTrack, trackPaths);
                    albumList.put(currentAlbum, trackList);
                    mp3HashMap.get(currentArtist).putAll(albumList);
                }
            } else {
                HashMap<String, HashMap<String, ArrayList<String>>> albumList = new HashMap<>();
                HashMap<String, ArrayList<String>> trackList = new HashMap<>();
                ArrayList<String> trackPaths = new ArrayList<>();
                trackPaths.add(currentPath);
                trackList.put(currentTrack, trackPaths);
                albumList.put(currentAlbum, trackList);
                mp3HashMap.put(currentArtist, albumList);
            }
        }
        return mp3HashMap;
    }


    public void printDuplicatesByTags(HashMap<String, HashMap<String, HashMap<String, ArrayList<String>>>> mp3HashMap){
        for (String artist : mp3HashMap.keySet()) {
            for (HashMap.Entry<String, HashMap<String, ArrayList<String>>> entry1 : mp3HashMap.get(artist).entrySet()) {
                for (HashMap.Entry<String, ArrayList<String>> entry2 : entry1.getValue().entrySet()) {
                    if(entry2.getValue().size()>=2){
                        System.out.println("Исполнитель: "+artist+" Альбом: "+entry1.getKey()+" Композиция: "+entry2.getKey());
                        for (int i = 0; i <entry2.getValue().size() ; i++) {
                            System.out.println("- "+entry2.getValue().get(i));
                        }
                    }
                }
            }
        }
    }

        }


