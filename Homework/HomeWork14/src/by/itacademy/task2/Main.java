package by.itacademy.task2;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        File folder = new File(args[0]);
        File[] files = folder.listFiles();
        //new Mp3CheckSum().Mp3CheckSum(files);


        ArrayList<Mp3File> mp3List = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            try {
                mp3List.add(new Mp3File(files[i].getAbsolutePath()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedTagException e) {
                e.printStackTrace();
            } catch (InvalidDataException e) {
                e.printStackTrace();
            }
        }


        HashMap<String, HashMap<String, HashMap<String,ArrayList<String>>>> mp3HashMap = new HashMap<>();


        for (Mp3File mp3File : mp3List) {
            String currentArtist = mp3File.getId3v2Tag().getArtist();
            if(currentArtist==null) {
            currentArtist="Unknown Artist";
            }
            String currentAlbum = mp3File.getId3v2Tag().getAlbum();
            if(currentAlbum==null) {
                currentAlbum="Unknown";
            }
            String currentTrack = mp3File.getId3v2Tag().getTitle();
            if(currentTrack==null){
                currentTrack="Unknown";
            }

            String currentLong = Integer.toString(mp3File.getId3v2Tag().getLength());

            String currentPath = mp3File.getFilename();

            if (mp3HashMap.containsKey(currentArtist)) {

                if (mp3HashMap.get(currentArtist).containsKey(currentAlbum)) {
                    ArrayList<String> trackInformation = new ArrayList<>();
                    trackInformation.add(currentLong);
                    trackInformation.add(currentPath);
                    mp3HashMap.get(currentArtist).get(currentAlbum).put(currentTrack,trackInformation);
                } else {
                    HashMap<String, HashMap<String,ArrayList<String>>> albumList = new HashMap<>();
                    HashMap<String,ArrayList<String>> trackList =  new HashMap<>();
                    ArrayList<String> trackInformation = new ArrayList<>();
                    trackInformation.add(currentLong);
                    trackInformation.add(currentPath);
                    trackList.put(currentTrack,trackInformation);
                    albumList.put(currentAlbum,trackList);
                    mp3HashMap.get(currentArtist).putAll(albumList);
                }

            } else {
                HashMap<String, HashMap<String,ArrayList<String>>> albumList = new HashMap<>();
                HashMap<String,ArrayList<String>> trackList =  new HashMap<>();
                ArrayList<String> trackInformation = new ArrayList<>();
                trackInformation.add(currentLong);
                trackInformation.add(currentPath);
                trackList.put(currentTrack,trackInformation);
                albumList.put(currentAlbum,trackList);
                mp3HashMap.put(currentArtist,albumList);

            }



        printMyMp3(mp3HashMap);

    }
    }


    public static void printMyMp3( HashMap<String, HashMap<String, HashMap<String,ArrayList<String>>>> mp3HashMap){

        for ( String artist: mp3HashMap.keySet()){
            System.out.println("Исполнитель  "+artist);


        }


    }

}



