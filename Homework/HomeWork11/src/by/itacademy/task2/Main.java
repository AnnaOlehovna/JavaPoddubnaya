package by.itacademy.task2;


import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static final String LINK = "http://kiparo.ru/t/test.xml";

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

                File file = new File("test.xml");
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[2048];
                while((byteRead = inputStream.read(buffer))!=-1){
                    fileOutputStream.write(buffer,0,byteRead);

                 parseXml();

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

    public static void parseXml(){
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = spf.newSAXParser();
            XMLReader xmlReader= saxParser.getXMLReader();
            Myhandler handler = new Myhandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse("test.xml");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}

