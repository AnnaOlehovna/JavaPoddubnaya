package by.itacademy.sorting;

import by.itacademy.entity.Weather;

import java.util.Comparator;


public class SortingMyTempMin implements Comparator<Weather> {

    @Override
    public int compare(Weather w1, Weather w2) {
        if(w1.getTempMin()==w2.getTempMin()) return 0;
        if(w1.getTempMin()>w2.getTempMin()) return 1;
        return -1;
    }
}
