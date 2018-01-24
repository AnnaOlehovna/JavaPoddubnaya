package by.itacademy.Search;

import by.itacademy.Entity.City;
import by.itacademy.Entity.Root;
import by.itacademy.Entity.Weather;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SearchingByCity implements Searching{

    private Root root;

    public void setRoot(Root root) {
        this.root = root;
    }

    public SearchingByCity(Root root) {
        this.root = root;
    }

    @Override
    public ArrayList<Weather> search(Object o) {
        String cityName = (String)o;
        ArrayList<Weather> weatherForCity = new ArrayList<>();
        for (int i = 0; i < root.getWeatherList().size() ; i++) {
            Weather weather = root.getWeatherList().get(i);
            for(HashMap.Entry<String, List<City>> entry :weather.getLocation().entrySet()){
                for(City city: entry.getValue()){
                    if(city.getName().equals(cityName)){
                        weatherForCity.add(weather);
                    }
                }
            }
        }
        return weatherForCity;
    }
}
