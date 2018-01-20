package by.itacademy.presentation;

import by.itacademy.ParseXML;
import by.itacademy.Parsing;

import java.io.File;
import java.io.UTFDataFormatException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Parsing parsing = new ParseXML();
        File file = new File("D:/weather.xml");
        parsing.parsingFile(file);

        
    }
}
