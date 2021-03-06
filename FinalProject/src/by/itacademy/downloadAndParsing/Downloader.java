package by.itacademy.downloadAndParsing;

import by.itacademy.manager.EventManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader extends EventManager  {

    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean download(String link) {
        boolean isDownloaded = false;
        String filePath ="";

        InputStream inputStream = null;

        FileOutputStream fileOutputStream = null;

        try {

            URL url = new URL(link);
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection) url.openConnection();

            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                inputStream = httpURLConnection.getInputStream();

                if (link.endsWith(".xml")) {
                   filePath = "weather.xml";
                } else if (link.endsWith(".json")) {
                    filePath = "weather.json";
                }

                file = new File(filePath);
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[2048];
                while ((byteRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, byteRead);
                }
                isDownloaded = true;
            } else {
                sendMessage("Данные не найдены, response code = " + responseCode);

            }

        } catch (Exception e) {
            sendMessage("Невозможно скачать файл. Проверьте подключение к интернету! ");
        } finally {
            if (inputStream != null && fileOutputStream != null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    sendMessage("Невозможно закрыть inputStream. Ошибка " + e.toString());
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    sendMessage("Невозможно закрыть fileOutputStream. Ошибка " + e.toString());

                }
            }

        }
        return isDownloaded;

    }


}
