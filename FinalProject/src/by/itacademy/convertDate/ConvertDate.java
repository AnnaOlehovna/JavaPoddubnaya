package by.itacademy.convertDate;


import by.itacademy.manager.EventManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertDate extends EventManager {
       /**
     * Convert date from String format to class Date according to the pattern
     *
     * @param dateInString String date
     * @return class Date
     */
    public Date convertStringtoDate(String dateInString) {
        Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
            try {
                date = sdf.parse(dateInString);
            } catch (ParseException e) {
                sendMessage("Невозможно распарсить дату");
            }

        return date;
    }

    public Date StringtoDate(String dateInString) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException e) {
            sendMessage("Невозможно распарсить дату");
        }

        return date;
    }


    public String convertDateToString(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss", Locale.forLanguageTag("RU"));
        return sdf.format(date);
    }
}
