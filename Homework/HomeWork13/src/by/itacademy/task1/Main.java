package by.itacademy.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        System.out.println("Write some text, please!");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String text = br.readLine();

            String regExp = "([a-zA-Z])\\1+";
            Pattern pattern = Pattern.compile(regExp);
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    int counter = end - start;
                    text = text.replaceFirst(regExp, "$1" + counter);
                }
            System.out.println(text);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
