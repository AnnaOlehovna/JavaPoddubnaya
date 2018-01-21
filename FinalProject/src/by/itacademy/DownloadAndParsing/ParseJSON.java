package by.itacademy.DownloadAndParsing;

import by.itacademy.Entity.Weather;
import by.itacademy.presentation.EventManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

/**
 * Parsing data from JSON to Entity
 */
public class ParseJSON extends EventManager implements Parsing{


    @Override
    public void parsingFile(File file) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Date.class, new DateGsonConvert());
            Gson gson = builder.create();

            Weather root = gson.fromJson(bufferedReader, Weather.class);
            System.out.println(root.toString());


        } catch (Exception e) {
            sendMessage("Hевозможно закрыть filereader " + e.toString());
        }

        }
    }

