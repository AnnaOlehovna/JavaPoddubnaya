package by.itacademy.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("^[\\w\\s-!?+@]+\\.([a-zA-z0-9]{3,5})$");
        Matcher matcher = pattern.matcher("sneg idet333.mp3");
        System.out.println(matcher.matches());
        System.out.println("Формат файла "+matcher.group(1));
    }
}
