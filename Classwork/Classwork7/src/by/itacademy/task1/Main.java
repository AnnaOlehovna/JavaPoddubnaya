package by.itacademy.task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by user on 01.12.2017.
 */
public class Main {
    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");//date and time pattern - oracle
        String dataText = sdf.format(date);
        System.out.println(dataText);

        String inPutData = "2017-11-30 17:50";
        Date data2 = null;
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);//date and time pattern - oracle

        try {
            data2 = sdf2.parse(inPutData);
        } catch (Exception e) {
            System.out.println("Неверный формат данных");
        }

        System.out.println(data2.toString());

        int day = date.getDate();
//одинарная ковычка эекранирует, выводит содержимое как есть, без замены на формат даты, разрывает шаблон
        String pattern = "MMMM dd'" + getPosDay(day) + "' hh:mm a";
        SimpleDateFormat sdf3 = new SimpleDateFormat(pattern, Locale.ENGLISH);
        System.out.println(sdf3.format(date));


        GregorianCalendar calendar= new GregorianCalendar();
        calendar.setTime(date);
        int dayCalend =calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int month=calendar.get(GregorianCalendar.MONTH);
        //прибавляет 30 дней
        calendar.add(GregorianCalendar.DATE,30);

        System.out.println(calendar.getTime().toString());






    }

    public static String getPosDay(int day) {
        String end = "";
        switch (day) {
            case 1:
            case 21:
            case 31:
                end = "st";
                return end;

            case 2:
            case 22:
                end = "nd";
                return end;
            case 3:
            case 23:
                end = "rd";
                return end;
            default:
                end = "th";
                return end;
        }
    }
}
