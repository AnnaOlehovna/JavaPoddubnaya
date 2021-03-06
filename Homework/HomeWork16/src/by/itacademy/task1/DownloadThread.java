package by.itacademy.task1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadThread extends Thread {

    final private String LINK_XML = "http://kiparo.ru/t/test.xml";
    final private String LINK_JSON = "http://kiparo.ru/t/test.json";


    @Override
    public  void run() {
        System.out.println("threadDownload start");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (Main.object){

            System.out.println("Downloading XML...");
            download(LINK_XML);
            Main.object.notify();

            System.out.println("Wait for parsing XML");
            try {
                Main.object.wait();
            } catch (InterruptedException e) {
            }

            System.out.println("Downloading JSON...");
            download(LINK_JSON);
            Main.object.notify();

            System.out.println("threadDownload end");
        }
    }



    private void download(String link) {
        String filePath = "";
        InputStream inputStream = null;

        FileOutputStream fileOutputStream = null;

        try {

            URL url = new URL(link);
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection) url.openConnection();

            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                inputStream = httpURLConnection.getInputStream();

                if(link.endsWith(".xml")){
                    filePath = "test.xml";
                }else if(link.endsWith(".json")){
                    filePath = "test.json";
                }

                File file = new File(filePath);
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[2048];
                while ((byteRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, byteRead);
                }
            } else {
                System.out.println("Данные не найдены, response code = " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Невозможно скачать файл. Ошибка " + e.toString());
        } finally {
            if (inputStream != null && fileOutputStream != null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Невозможно закрыть inputStream. Ошибка " + e.toString());
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    System.out.println("Невозможно закрыть fileOutputStream. Ошибка " + e.toString());
                }
            }
        }
    }
}
