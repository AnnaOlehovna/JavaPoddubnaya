package by.itacademy.task1;


import by.itacademy.task1.Entity.DateGsonConvert;
import by.itacademy.task1.Entity.People;
import by.itacademy.task1.Entity.Root;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static final String LINK2 = "http://kiparo.ru/t/test.json";

    public static void main(String[] args) {

        InputStream inputStream = null;

        FileOutputStream fileOutputStream= null;

        try{

            URL url = new URL(LINK2);
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection)url.openConnection();

            int responseCode = httpURLConnection.getResponseCode();

            if(responseCode==HttpURLConnection.HTTP_OK){

                inputStream = httpURLConnection.getInputStream();

                File file = new File("test.json");
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[2048];
                while((byteRead = inputStream.read(buffer))!=-1){
                    fileOutputStream.write(buffer,0,byteRead);

                    parseJson();
//                    parseGson();

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


    public static void parseJson(){
        JSONParser parser = new JSONParser();

        FileReader fileReader = null;

        try{
            Root rootModel = new Root();
            fileReader = new FileReader("test.json");

            JSONObject root = (JSONObject) parser.parse(fileReader);

            String nameRoot = (String) root.get("name");
            System.out.println("name = "+nameRoot);

            String gender = (String) root.get("name");
            System.out.println("name = "+nameRoot);

            JSONArray peopleList = (JSONArray) root.get("people");

            List<People> peopleModel = new ArrayList<>();

            for(Object elemets: peopleList){

                JSONObject people = (JSONObject) elemets;

                long id =(Long) people.get("id");
                System.out.println("id = "+id);

                long age = (Long) people.get("age");
                System.out.println("age = "+age);

                String name = (String) people.get("name");
                System.out.println("name = "+name);

                String surname = (String) people.get("surname");
                System.out.println("surname = "+surname);

                boolean isDegree = (Boolean) people.get("isDegree");
                System.out.println("isDegree = "+isDegree);


                peopleModel.add(new People((int)id,name,surname,(int) age,isDegree));
            }

            rootModel.setName(nameRoot);
            rootModel.setPeople(peopleModel);

            System.out.println(rootModel.toString());



        }catch (Exception e){
            System.out.println("Невозможно открыть json, error = "+e.toString());
        }finally {
            if(fileReader!=null){
                try{
                    fileReader.close();
                }catch (IOException e){
                    System.out.println("невозможно закрыть filereader "+e.toString());
                }

            }
        }
    }



    private static void parseGson(){

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("test.json"));

            GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Date.class, new DateGsonConvert());
            Gson gson = builder.create();

            Root root = gson.fromJson(bufferedReader,Root.class);
            System.out.println(root.toString());

        }catch (Exception e){
                System.out.println("невозможно закрыть filereader "+e.toString());
            }
    }
}
