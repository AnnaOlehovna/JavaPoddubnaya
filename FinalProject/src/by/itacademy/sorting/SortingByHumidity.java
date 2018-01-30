package by.itacademy.sorting;

import by.itacademy.entity.Weather;

import java.util.Comparator;

public class SortingByHumidity implements Comparator<Weather> {
    @Override
    public int compare(Weather w1, Weather w2) {
        if(w1.getHumidity()==w2.getHumidity()) return 0;
        if(w1.getHumidity()>w2.getHumidity()) return 1;
        return -1;
    }
}
