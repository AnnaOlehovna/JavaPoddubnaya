package by.itacademy.presentation;

import java.io.UTFDataFormatException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");

        try {
            date = sdf.parse("2015-04-25 12:35:00 +0400");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date.toString());
        
    }
}
