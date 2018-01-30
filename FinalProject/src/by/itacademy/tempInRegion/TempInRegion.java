package by.itacademy.tempInRegion;

import by.itacademy.entity.City;
import by.itacademy.entity.Root;
import by.itacademy.entity.Weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TempInRegion {

    private Root root;

    public void setRoot(Root root) {
        this.root = root;
    }

    public TempInRegion(Root root) {
        this.root = root;
    }

    /**
     * Finds max temperature during all time period for every city
     * @return name of City and its max temperature
     */
    public HashMap<City,Integer> maxTemp(){
        HashMap<City,Integer> maxHashMap= new HashMap<>();
        for (int i = 0; i < root.getWeatherList().size() ; i++) {
            Weather weather = root.getWeatherList().get(i);
            for(HashMap.Entry<String, List<City>> entry :weather.getLocation().entrySet()){
                for(City city: entry.getValue()){
                    if(maxHashMap.containsKey(city)){
                        if(maxHashMap.get(city)<weather.getTempMax()){
                            maxHashMap.put(city,weather.getTempMax());
                        }
                    }else{
                        maxHashMap.put(city,weather.getTempMax());
                    }
                }
            }
        }
        return maxHashMap;
    }


    /**
     * Calculate average temperature during all time period for every city
     * @return name of City and its average temperature
     */
    public  HashMap<City,Double> averageTemp(){
        HashMap<City,ArrayList<Integer>> hashMap = new HashMap<>();
        HashMap<City,Double> averageHashMap= new HashMap<>();
        for (int i = 0; i < root.getWeatherList().size() ; i++) {
            Weather weather = root.getWeatherList().get(i);
            for(HashMap.Entry<String, List<City>> entry :weather.getLocation().entrySet()){
                for(City city: entry.getValue()){
                    if(hashMap.containsKey(city)){
                        hashMap.get(city).add(weather.getTempMin());
                        hashMap.get(city).add(weather.getTempMax());
                    }else{
                        ArrayList<Integer> temps = new ArrayList<>();
                        temps.add(weather.getTempMax());
                        temps.add(weather.getTempMin());
                        hashMap.put(city,temps);
                    }
                }
            }
        }
        for (HashMap.Entry<City,ArrayList<Integer>> entry:hashMap.entrySet()) {
            double summ = 0;
            for (Integer temp: entry.getValue()){
                summ=summ+temp;
            }
            double averageTemp = summ/(entry.getValue().size());
            averageHashMap.put(entry.getKey(),averageTemp);
        }
        return averageHashMap;
    }
}
