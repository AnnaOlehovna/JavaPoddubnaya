package by.itacademy.task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("D:\\Всякое\\JavaPoddubnaya\\For homework7.txt");
            int c;
            while((c=reader.read())!=-1) {

                System.out.print((char)c);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


        try {
            FileWriter writer = new FileWriter("D:\\Всякое\\JavaPoddubnaya\\For homework7.txt",true);

            String text = "And sing!";
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
