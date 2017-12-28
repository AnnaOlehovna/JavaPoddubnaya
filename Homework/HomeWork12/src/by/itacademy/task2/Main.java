package by.itacademy.task2;

import by.itacademy.task2.Entity.Root;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Root root = mapper.readValue(new URL("http://kiparo.ru/t/test.json"), Root.class);
            System.out.println(root.toString());
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
