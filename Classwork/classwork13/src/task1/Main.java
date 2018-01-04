package task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * регулярные выражения
 */
    public class Main {
    public static void main(String[] args) {

        String text = "@abs@gmail.com@";
       text=text.replaceAll("@$","");
        System.out.println(text);

        String text3 = "@abs@gmail.com@";
        text3=text3.replaceAll("^@|@$","");
        System.out.println(text3);

        String text2 = "$abs@gmail.com@";
        text2=text2.replaceAll("\\$","");
        System.out.println(text2);


        //проверка номера машины РБ
        System.out.println("Номер машины");
        String text4 = "2020 MP-7";
        System.out.println(text4);

        Pattern pattern = Pattern.compile("^[0-9]{4} [A-Z]{2}-[1-7]$");
        Matcher matcher = pattern.matcher(text4);
        if(matcher.matches()){
            System.out.println("Номер корректный");
        }
            else{
            System.out.println("Номер не корректный");
        }


        System.out.println("номер телефона");
        String text5 = "+375 (29) 111-11-11";
        System.out.println(text5);
        text5=text5.replaceAll("\\D","");
        Pattern pattern2 = Pattern.compile("^375(17|29|33|44|25)[0-9]{7}$");
        Matcher matcher2 = pattern2.matcher(text5);
        if(matcher2.matches()){
            System.out.println("Номер корректный");
        }
        else{
            System.out.println("Номер не корректный");
        }
    }

}
