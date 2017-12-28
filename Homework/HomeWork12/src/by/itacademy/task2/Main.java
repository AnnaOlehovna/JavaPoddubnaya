package by.itacademy.task2;

import by.itacademy.task2.Entity.Root;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Root root = null;
            try {
                root = mapper.readValue(new URL("http://kiparo.ru/t/test.json"), Root.class);
            } catch (JsonMappingException e) {
                e.printStackTrace();
            }
            System.out.println(root.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
