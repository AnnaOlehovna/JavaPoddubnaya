package by.itacademy.Search;

import by.itacademy.Entity.City;
import by.itacademy.Entity.Root;
import by.itacademy.Entity.Weather;

import java.util.*;


public class Searching {

    private Root root;


    public Searching(Root root) {
        this.root = root;
    }

    /**
     * Make search through the Root by temperature range
     * @param minTemp min temperature
     * @param maxTemp max temperature
     * @return cities with temperature between minTemp and maxTemp
     */
    public HashSet<City> searchByTemperatureRange(int minTemp, int maxTemp) {
        HashSet<City> cities = new HashSet<>();
        for (int i = 0; i < root.getWeatherList().size(); i++) {
            Weather weather = root.getWeatherList().get(i);
            if (minTemp <= weather.getTempMin() && maxTemp >= weather.getTempMax()) {
                for (HashMap.Entry<String, List<City>> entry : weather.getLocation().entrySet()) {
                    cities.addAll(entry.getValue());
                }
            }
        }
        return cities;
    }

    /**
     * Make search through the Root by name of the city
     * @param nameCity name of the searching city
     * @return Weather that contains asked city
     */
    public Root searchByCity(String nameCity) {
        Root rootOnRequest = new Root();
        ArrayList<Weather> weatherForCity = new ArrayList<>();
        for (int i = 0; i < root.getWeatherList().size() ; i++) {
            Weather weather = root.getWeatherList().get(i);
            for(HashMap.Entry<String, List<City>> entry :weather.getLocation().entrySet()){
                for(City city: entry.getValue()){
                    if(city.getName().toLowerCase().equals(nameCity.toLowerCase())){
                        weatherForCity.add(weather);
                    }
                }
            }
        }
        rootOnRequest.setDate(root.getDate());
        rootOnRequest.setName(root.getName());
        rootOnRequest.setWeatherList(weatherForCity);

        return rootOnRequest;
    }
}
