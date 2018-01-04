package task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 03.01.2018.
 */
public class Main {
    public static void main(String[] args) {

    }



    public static boolean checkCarNumber(String text){
        Pattern pattern = Pattern.compile("^[0-9]{4} [A-Z]{2}-[1-7]$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean checkPhoneNumber(String text){
        text=text.replaceAll("\\D","");
        Pattern pattern = Pattern.compile("^375(17|29|33|44|25)[0-9]{7}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
