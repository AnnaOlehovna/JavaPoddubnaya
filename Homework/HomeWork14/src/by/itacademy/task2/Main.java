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
        HashMap<String,ArrayList<String>> artistAlbum = new HashMap<>();
        for (Mp3File mp3File:mp3List){
            System.out.println(mp3File.getId3v2Tag().getArtist());


            }
        }

}



