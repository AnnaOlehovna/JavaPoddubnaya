package by.itacademy.task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by user on 11.12.2017.
 */
public class Main {
   public static final String LINK = "https://www.tut.by/";

    public static void main(String[] args) {

        InputStream inputStream = null;

        FileOutputStream fileOutputStream= null;

        try{

            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection)url.openConnection();

            int responseCode = httpURLConnection.getResponseCode();

            if(responseCode==HttpURLConnection.HTTP_OK){

                inputStream = httpURLConnection.getInputStream();

                File file = new File("ex.html");
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[2048];
                while((byteRead = inputStream.read(buffer))!=-1){
                    fileOutputStream.write(buffer,0,byteRead);
                }
            }else {
                System.out.println("Данные не найдены, response code = "+responseCode);
            }

        }catch (Exception e){
            System.out.println("Невозможно скачать файл. Ошибка "+e.toString());
        }finally {
            if(inputStream!=null&&fileOutputStream!=null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Невозможно закрыть inputStream. Ошибка "+e.toString());
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    System.out.println("Невозможно закрыть fileOutputStream. Ошибка "+e.toString());
                }
            }
        }
    }

}
