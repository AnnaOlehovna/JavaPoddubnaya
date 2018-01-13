package by.itacademy.task1;

import by.itacademy.task1.EntityJSON.DateGsonConvert;
import by.itacademy.task1.EntityJSON.Root;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class ParsingThread extends Thread {

    @Override
    public void run() {

        System.out.println("threadParsing start");

        synchronized (Main.object) {

            System.out.println("Wait for XML");
            try {
                Main.object.wait();
            } catch (InterruptedException e) {
            }

            System.out.println("XML parsing");
            parseXml();
            Main.object.notify();


            System.out.println("Wait for JSON");
            try {
                Main.object.wait();
            } catch (InterruptedException e) {
            }

            System.out.println("JSON parsing");
            parseGson();

            System.out.println("threadParsing end");

        }
    }


    public static void parseXml() {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = spf.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            Myhandler handler = new Myhandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse("test.xml");
            System.out.println(handler.getRoot().toString());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void parseGson() {

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("test.json"));

            GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Date.class, new DateGsonConvert());
            Gson gson = builder.create();

            Root root = gson.fromJson(bufferedReader, Root.class);
            System.out.println(root.toString());

        } catch (Exception e) {
            System.out.println("невозможно закрыть filereader " + e.toString());
        }
    }

}
