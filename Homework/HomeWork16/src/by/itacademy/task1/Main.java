package by.itacademy.task1;

public class Main {

    public final static Object object = new Object();

    public static void main(String[] args) {

        ParsingThread parsingThread = new ParsingThread();
        parsingThread.setName("parsingThread");
        DownloadThread downloadThread = new DownloadThread();
        downloadThread.setName("downloadThread");


        downloadThread.start();
        parsingThread.start();
    }
}
