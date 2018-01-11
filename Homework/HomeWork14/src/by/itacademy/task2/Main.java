package by.itacademy.task2;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        File folder = new File(args[0]);
        File[] files = folder.listFiles();


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
        CatalogMp3 currentCatalog = new CatalogMp3();
        currentCatalog.printMyMp3(currentCatalog.createCatalogAll(mp3List));
        System.out.println();
        new Mp3CheckSum().Mp3CheckSum(files);
        System.out.println();
        DuplicateByTags duplicateByTags = new DuplicateByTags();
        duplicateByTags.printDuplicatesByTags(duplicateByTags.createCatalogNoDuplicate(mp3List));

    }




    }







