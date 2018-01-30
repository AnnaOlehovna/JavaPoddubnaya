package by.itacademy.weatherByDates;

import by.itacademy.entity.Root;
import by.itacademy.entity.Weather;
import by.itacademy.convertDate.ConvertDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class WeatherByDates {


    private Root root;
    private ConvertDate convertDate = new ConvertDate();

    public WeatherByDates(Root root) {
        this.root = root;
    }

    public Root showWeatherByDates(String date) {
        Date dateToFind = convertDate.StringtoDate(date);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dateToFind);
        Root rootOnRequest = new Root();
        ArrayList<Weather> weathers = new ArrayList<>();
        for (Weather weather : root.getWeatherList()) {
            GregorianCalendar gcFromRoot = new GregorianCalendar();
            gcFromRoot.setTime(weather.getDate());
            if (gc.get(Calendar.YEAR) == gcFromRoot.get(Calendar.YEAR) && gc.get(Calendar.MONTH) == gcFromRoot.get(Calendar.MONTH) &&
                    gc.get(Calendar.DAY_OF_MONTH) == gcFromRoot.get(Calendar.DAY_OF_MONTH)) {
                weathers.add(weather);
            }
        }
        rootOnRequest.setName(root.getName());
        rootOnRequest.setDate(root.getDate());
        rootOnRequest.setWeatherList(weathers);

        return rootOnRequest;
    }


    public Root showWeatherByDates(String dateFrom, String dateTo) {
        Date dateStart = convertDate.StringtoDate(dateFrom);
        Date dateEnd = convertDate.StringtoDate(dateTo);
        Root rootOnRequest = new Root();
        ArrayList<Weather> weathers = new ArrayList<>();

        for (Weather weather : root.getWeatherList()) {
            if (dateStart.before(weather.getDate())  &&
                    dateEnd.after(weather.getDate())) {
                weathers.add(weather);
            }
        }
        rootOnRequest.setName(root.getName());
        rootOnRequest.setDate(root.getDate());
        rootOnRequest.setWeatherList(weathers);


        return rootOnRequest;
    }
}
