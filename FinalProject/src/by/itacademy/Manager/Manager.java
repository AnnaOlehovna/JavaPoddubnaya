package by.itacademy.Manager;


import by.itacademy.DownloadAndParsing.Downloader;
import by.itacademy.DownloadAndParsing.ParseJSON;
import by.itacademy.DownloadAndParsing.ParseXML;
import by.itacademy.DownloadAndParsing.Parsing;
import by.itacademy.Entity.City;
import by.itacademy.Entity.Root;
import by.itacademy.Entity.Weather;
import by.itacademy.Presentation.Main;
import by.itacademy.Search.Searching;
import by.itacademy.Sorting.SortingByHumidity;
import by.itacademy.Sorting.SortingByTempMax;
import by.itacademy.Sorting.SortingMyTempMin;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Manager implements Listener {
    private final String LINK_XML = "http://kiparo.ru/t/weather.xml";
    private final String LINK_JSON = "http://kiparo.ru/t/weather.json";

    private Main main = new Main();
    private static Manager instance = new Manager();
    private Root root;


    private Manager() {
    }

    public static Manager getInstance() {
        return instance;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    /**
     * Method for downloading and parsing files
     * according to the User's choice
     * @param choice int
     */
    public void downloadingAndParsing(int choice) {
        Thread myThread = new Thread(() -> {
            Downloader downloader = new Downloader();
            Parsing parsing;
            File file;
            switch (choice) {
                case 1:
                    downloader.download(LINK_XML);
                    parsing = new ParseXML();
                    break;
                case 2:
                    downloader.download(LINK_JSON);
                    parsing = new ParseJSON();
                    break;
                case 3:
                    Main.goodByeMessage();
                    return;
                default:
                    getMessage("Неверный ввод!");
                    return;

            }
            file = downloader.getFile();
           root=parsing.parsingFile(file);
        });

        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            getMessage("My Thread was interrupted");
        }
    }

    /**
     * Method for sorting data
     * according to the User's choice
     * @param choice int
     */
    public void sorting(int choice) {
        Comparator<Weather> weatherComparator;
        switch (choice) {
            case 1:
                weatherComparator = new SortingByHumidity();
                break;
            case 2:
                weatherComparator = new SortingByTempMax();
                break;
            case 3:
                weatherComparator = new SortingMyTempMin();
                break;
            case 4:
                Main.goodByeMessage();
                return;
            default:
                getMessage("Неверный ввод!");
                return;
        }
        root.getWeatherList().sort(weatherComparator);
        getMessage(root.toString());
    }

    public void searching(int choice){
        Searching searching = new Searching(root);
        switch (choice){
            case 1:
                ArrayList<Weather> weatherInCurrentCity= searching.searchByCity(main.askForCity());
               if(weatherInCurrentCity.size()!=0){
                   getMessage(weatherInCurrentCity.toString());}
               else{
                   getMessage("Данных по такому городу нет");
               }
               break;
            case 2:
                HashSet<City> cities = searching.searchByTemperatureRange(main.askForTempMin(),main.askForTempMax());
                if(cities.size()!=0){
                    getMessage(cities.toString());
                }else{
                    getMessage("Городов с таким диапазоном температур не найдено");
                }
                break;
            case 3:
                Main.goodByeMessage();
                break;
            default:
                getMessage("Неверный ввод!");
        }

    }


    @Override
    public void getMessage(String message) {
        main.printMessages(message);
    }

}
