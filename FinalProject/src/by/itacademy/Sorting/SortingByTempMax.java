package by.itacademy.Sorting;

import by.itacademy.Entity.Weather;

import java.util.Comparator;

public class SortingByTempMax implements Comparator<Weather> {


    @Override
    public int compare(Weather w1, Weather w2) {
        if(w1.getTempMax()==w2.getTempMax()) return 0;
        if(w1.getTempMax()>w2.getTempMax()) return 1;
        return -1;

    }
}
