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


        HashMap<String, HashMap<String, ArrayList<String>>> mp3HashMap = new HashMap<>();
        for (Mp3File mp3File : mp3List) {
            String currentArtist = mp3File.getId3v2Tag().getArtist();
            if(currentArtist==null) {
            currentArtist="Unknown Artist";
            }
            String currentAlbum = mp3File.getId3v2Tag().getAlbum();
            if(currentAlbum==null) {
                currentAlbum="Unknown";
            }
            String currentTrack = mp3File.getId3v2Tag().getTrack();
            if(currentTrack==null){
                currentTrack="Unknown";
            }
            if (mp3HashMap.containsKey(currentArtist)) {

            } else {
                if (mp3HashMap.get(currentArtist).containsKey(currentAlbum)) {
                    mp3HashMap.get(currentArtist).get(currentAlbum).add(currentTrack);
                } else {
                    ArrayList<String> trackList = new ArrayList<>();
                    trackList.add(currentTrack);
                    HashMap<String, ArrayList<String>> albumList = new HashMap<>();
                    albumList.put(currentAlbum,trackList);
                    mp3HashMap.get(currentArtist).putAll(albumList);
                }
                ArrayList<String> trackList = new ArrayList<>();
                trackList.add(currentTrack);
                HashMap<String, ArrayList<String>> albumList = new HashMap<>();
                albumList.put(currentAlbum,trackList);
                mp3HashMap.put(currentArtist,albumList);

            }

        }

        printMyMp3(mp3HashMap);

    }


    public static void printMyMp3( HashMap<String, HashMap<String, ArrayList<String>>> mp3HashMap){

        for ( HashMap.Entry<String, HashMap<String, ArrayList<String>>> entry: mp3HashMap.entrySet()){
            System.out.println("Исполнитель  "+entry.getKey());

            for(HashMap.Entry<String, ArrayList<String>> entry1 : entry.getValue().entrySet()){
                System.out.println("     Альбом: "+ entry1.getKey());

                for (int i=0; i<entry1.getValue().size();i++){
                    System.out.println("           Название: "+entry1.getValue().get(i));
                }
            }
        }


    }

}



