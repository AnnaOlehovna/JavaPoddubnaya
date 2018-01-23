package by.itacademy.Manager;


import by.itacademy.DownloadAndParsing.Downloader;
import by.itacademy.DownloadAndParsing.ParseJSON;
import by.itacademy.DownloadAndParsing.ParseXML;
import by.itacademy.DownloadAndParsing.Parsing;
import by.itacademy.Presentation.Main;

import java.io.File;

public class Manager implements Listener {
    private final String LINK_XML = "http://kiparo.ru/t/weather.xml";
    private final String LINK_JSON = "http://kiparo.ru/t/weather.json";

    Main main = new Main();
    private static Manager instance = new Manager();


    private Manager() {
    }

    public static Manager getInstance() {
        return instance;
    }



    public void downloadingAndParsing(int choice) {
        Thread myThread = new Thread(() -> {
            Downloader downloader = new Downloader();
            Parsing parsing=null;
            File file=null;
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
                    main.printMessages("Всего доброго!");
                    return;
                default:
                    main.printMessages("Неверный ввод!");
                    return;

            }
            file = downloader.getFile();
            parsing.parsingFile(file);
                });

        myThread.start();
    }



    @Override
    public void getProblem(String problem) {
        main.printMessages(problem);
    }
}
