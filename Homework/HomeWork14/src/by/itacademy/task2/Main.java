package by.itacademy.task2;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Mp3File> mp3List = new ArrayList<>();


        for (int i = 0; i < args.length; i++) {
            try {
                Mp3File mp3File = new Mp3File(args[i]);
                mp3List.add(mp3File);



            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedTagException e) {
                e.printStackTrace();
            } catch (InvalidDataException e) {
                e.printStackTrace();
            }
        }


    }
}
