package by.itacademy.manager;


import by.itacademy.downloadAndParsing.Downloader;
import by.itacademy.downloadAndParsing.ParseJSON;
import by.itacademy.downloadAndParsing.ParseXML;
import by.itacademy.downloadAndParsing.Parsing;
import by.itacademy.entity.City;
import by.itacademy.entity.Root;
import by.itacademy.entity.Weather;
import by.itacademy.presentation.MyUI;
import by.itacademy.presentation.UIInterface;
import by.itacademy.search.Searching;
import by.itacademy.sorting.SortingByHumidity;
import by.itacademy.sorting.SortingByTempMax;
import by.itacademy.sorting.SortingMyTempMin;
import by.itacademy.tempInRegion.TempInRegion;
import by.itacademy.weatherByDates.WeatherByDates;

import java.io.File;
import java.util.Comparator;
import java.util.HashSet;

public class Manager implements Listener {
    private final String LINK_XML = "http://kiparo.ru/t/weather.xml";
    private final String LINK_JSON = "http://kiparo.ru/t/weather.json";

    private UIInterface UI = new MyUI();
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
     * @param choice String
     */
    public void downloadingAndParsing(String choice) {
        Thread myThread = new Thread(() -> {
            Downloader downloader = new Downloader();
            Parsing parsing;
            File file;
            String filepath=null;
            switch (choice) {
                case "1":
                    if(downloader.download(LINK_XML)){
                        getMessage("Загрузка прошла успешно");
                    }else{
                        getMessage("Проверка наличия файла локально");
                    }
                    if(new File("weather.xml").exists()){
                        filepath="weather.xml";
                    }
                    parsing = new ParseXML();
                    break;
                case "2":
                    if(downloader.download(LINK_JSON)){
                        getMessage("Загрузка прошла успешно");
                    }else{
                        getMessage("Проверка наличия файла локально");
                    }
                    if(new File("weather.json").exists()){
                        filepath="weather.json";
                    }
                    parsing = new ParseJSON();
                    break;
                case "3":
                    UI.goodByeMessage();
                    return;
                default:
                    getMessage("Неверный ввод! Попробуйте снова!");
                    UI.startUI();
                    return;
            }
            if (filepath != null) {
                file =new File(filepath);
                root = parsing.parsingFile(file);
            }else {
                getMessage("Файл не был сохранен локально ранее");
            }


        });
        myThread.setName("My Thread");
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            getMessage(Thread.currentThread().getName()+"was interrupted");
        }

        if(root!=null){
            getMessage("Парсинг прошел успешно!");
            UI.Menu();
        }

    }


    /**
     * Method for showing data
     * according to the User's choice
     * @param choice String
     */
    public void showRootAccordingDates(String choice){
        Root currentRoot;
        WeatherByDates weatherByDates = new WeatherByDates(root);
        switch (choice){
            case "1":
                getMessage(root.toString());
                break;
            case "2":
                currentRoot = weatherByDates.showWeatherByDates(UI.askForData());
                if(currentRoot.getWeatherList().size()!=0){
                    getMessage(currentRoot.toString());
                }else{
                    getMessage("По этой дате ничего не найдено!");
                }
                break;
            case "3":
                currentRoot = weatherByDates.showWeatherByDates(UI.askForData(),UI.askForData());
               if(currentRoot.getWeatherList().size()!=0){
                getMessage(currentRoot.toString());}
                else{
                   getMessage("За этот период ничего не найдено!");
               }
                break;
            case "4":
                UI.Menu();
                return;
            case "5":
                UI.goodByeMessage();
                return;
            default:
                getMessage("Неверный ввод! Попробуйте еще раз!");
                UI.outputWeatherUI();
                return;
        }
        UI.askForRepeat();

    }

    /**
     * Method for searching data
     * according to the User's choice
     * @param choice String
     */
    public void searching(String choice) {
        Searching searching = new Searching(root);
        switch (choice) {
            case "1":
                Root currentRoot = searching.searchByCity(UI.askForCity());
                if (currentRoot.getWeatherList().size() != 0) {
                    getMessage(currentRoot.toString());
                } else {
                    getMessage("Данных по такому городу нет");
                }
                break;
            case "2":
                HashSet<City> cities = searching.searchByTemperatureRange(UI.askForTempMin(), UI.askForTempMax());
                if (cities.size() != 0) {
                    getMessage(cities.toString());
                } else {
                    getMessage("Городов с таким диапазоном температур не найдено! Попробуйте еще раз!");
                    UI.searchUI();
                    return;
                }
                break;
            case "3":
                UI.Menu();
                return;
            case "4":
                UI.goodByeMessage();
                return;
            default:
                getMessage("Неверный ввод! Попробуйте еще раз!");
                UI.searchUI();
                return;
        }
        UI.askForRepeat();

    }


    /**
     * Method for sorting data
     * according to the User's choice
     * @param choice String
     */
    public void sorting(String choice) {
        Comparator<Weather> weatherComparator;
        switch (choice) {
            case "1":
                weatherComparator = new SortingByHumidity();
                break;
            case "2":
                weatherComparator = new SortingByTempMax();
                break;
            case "3":
                weatherComparator = new SortingMyTempMin();
                break;
            case "4":
                UI.Menu();
                return;
            case "5":
                UI.goodByeMessage();
                return;
            default:
                getMessage("Неверный ввод! Попробуйте еще раз");
                UI.sortUI();
                return;
        }
        root.getWeatherList().sort(weatherComparator);
        getMessage(root.toString());
        UI.askForRepeat();
    }


    public void tempInRegion(String choice){
        TempInRegion tempInRegion=new TempInRegion(root);
        switch (choice){
            case "1":
                UI.printMessages(tempInRegion.maxTemp().toString());
                break;
            case "2":
                UI.printMessages(tempInRegion.averageTemp().toString());
                break;
            case "3":
                UI.Menu();
                return;
            case "4":
                UI.goodByeMessage();
                return;
            default:
                getMessage("Неверный ввод! Попробуйте еще раз");
                UI.tempInRegionUI();
                return;

        }
        UI.askForRepeat();

    }






    @Override
    public void getMessage(String message) {
        UI.printMessages(message);
    }

}
