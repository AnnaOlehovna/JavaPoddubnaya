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
import by.itacademy.WeatherByDates.WeatherByDates;

import java.io.File;
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
     *
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
                    getMessage("Загрузка и парсинг XML прошли успешно!");
                    break;
                case 2:
                    downloader.download(LINK_JSON);
                    parsing = new ParseJSON();
                    getMessage("Загрузка и парсинг JSON прошли успешно!");
                    break;
                case 3:
                    Main.goodByeMessage();
                    return;
                default:
                    getMessage("Неверный ввод!");
                    return;

            }
            file = downloader.getFile();
            root = parsing.parsingFile(file);
        });
        myThread.setName("My Thread");
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            getMessage(Thread.currentThread().getName()+"was interrupted");
        }
    }


    /**
     * Method for showing data
     * according to the User's choice
     *
     * @param choice int
     */
    public void showRootAccordingDates(int choice){
        Root currentRoot;
        WeatherByDates weatherByDates = new WeatherByDates(root);
        switch (choice){
            case 1:
                getMessage(root.toString());
                main.askForRepeat();
                break;
            case 2:
                currentRoot = weatherByDates.showWeatherByDates(main.askForData());
                if(currentRoot.getWeatherList().size()!=0){
                    getMessage(currentRoot.toString());
                }else{
                    getMessage("По это дате ничего не найдено!");
                }
                main.askForRepeat();
                break;
            case 3:
                currentRoot = weatherByDates.showWeatherByDates(main.askForData(),main.askForData());
               if(currentRoot.getWeatherList().size()!=0){
                getMessage(currentRoot.toString());}
                else{
                   getMessage("За этот период ничего не найдено!");
               }
                main.askForRepeat();
                break;
            case 4:
                Main.startMenu();
                break;
            case 5:
                Main.goodByeMessage();
                break;
            default:
                getMessage("Неверный ввод! Попробуйте еще раз!");
                Main.outputWeatherUI();
                break;
        }

    }

    /**
     * Method for searching data
     * according to the User's choice
     * @param choice int
     */
    public void searching(int choice) {
        Searching searching = new Searching(root);
        switch (choice) {
            case 1:
                Root currentRoot = searching.searchByCity(main.askForCity());
                if (currentRoot.getWeatherList().size() != 0) {
                    getMessage(currentRoot.toString());
                } else {
                    getMessage("Данных по такому городу нет");
                }
                main.askForRepeat();
                break;
            case 2:
                HashSet<City> cities = searching.searchByTemperatureRange(main.askForTempMin(), main.askForTempMax());
                if (cities.size() != 0) {
                    getMessage(cities.toString());
                } else {
                    getMessage("Городов с таким диапазоном температур не найдено! Попробуйте еще раз!");
                    Main.searchUI();
                    break;
                }
                main.askForRepeat();
                break;
            case 3:
                Main.startMenu();
                break;
            case 4:
                Main.goodByeMessage();
                break;
            default:
                getMessage("Неверный ввод! Попробуйте еще раз!");
                Main.searchUI();
                break;
        }

    }


    /**
     * Method for sorting data
     * according to the User's choice
     *
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
                Main.startMenu();
                return;
            case 5:
                Main.goodByeMessage();
                return;
            default:
                getMessage("Неверный ввод! Попробуйте еще раз");
                Main.sortUI();
                return;
        }
        root.getWeatherList().sort(weatherComparator);
        getMessage(root.toString());
        main.askForRepeat();
    }






    @Override
    public void getMessage(String message) {
        main.printMessages(message);
    }

}
