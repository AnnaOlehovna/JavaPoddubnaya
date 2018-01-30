package by.itacademy.downloadAndParsing;

import by.itacademy.entity.City;
import by.itacademy.entity.Root;
import by.itacademy.entity.Weather;
import by.itacademy.convertDate.ConvertDate;
import by.itacademy.manager.EventManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parsing data from JSON to entity
 */
public class ParseJSON extends EventManager implements Parsing {


   private ConvertDate convertDate = new ConvertDate();


    @Override
    public Root parsingFile(File file) {
        if(file!=null){
            Root root = new Root();
            JSONParser parser = new JSONParser();

            FileReader fileReader = null;

            try{

                fileReader = new FileReader(file);

                JSONObject rootJson = (JSONObject) parser.parse(fileReader);

                String nameRoot = (String) rootJson.get("name");
                Date dateRoot = convertDate.convertStringtoDate((String)rootJson.get("date"));

                JSONArray weatherListJson = (JSONArray) rootJson.get("weather");

                List<Weather> weatherList = new ArrayList<>();

                for(Object elemets: weatherListJson){

                    JSONObject weatherJson = (JSONObject) elemets;


                    long id =(Long) weatherJson.get("id");

                    String title = (String) weatherJson.get("title");
                    String description = (String) weatherJson.get("description");
                    Date date = convertDate.convertStringtoDate((String)weatherJson.get("date"));
                    long tempMin =(Long) weatherJson.get("temp_min");
                    long tempMax =(Long) weatherJson.get("temp_max");
                    long humidity =(Long) weatherJson.get("humidity");

                    JSONArray locationListJson = (JSONArray) weatherJson.get("location");

                    HashMap<String, List<City>> locationMap = new HashMap<>();

                    for (Object aLocationListJson : locationListJson) {

                        String string = (String) aLocationListJson;
                        Pattern pattern = Pattern.compile("^([A-Za-z0-9-]+), ([A-Z]{2})$");
                        Matcher matcher = pattern.matcher(string);
                        if (matcher.matches()) {
                            String key = matcher.group(2);
                            String cityName = matcher.group(1);
                            City city = new City();
                            city.setName(cityName);
                            if (locationMap.containsKey(key)) {
                                locationMap.get(key).add(city);
                            } else {
                                List<City> cityList = new ArrayList<>();
                                cityList.add(city);
                                locationMap.put(key, cityList);
                            }
                        }
                    }
                    Weather weather = new Weather();
                    weather.setDate(date);
                    weather.setDescription(description);
                    weather.setHumidity((int)humidity);
                    weather.setId((int)id);
                    weather.setLocation(locationMap);
                    weather.setTempMax((int)tempMax);
                    weather.setTempMin((int)tempMin);
                    weather.setTitle(title);
                    weatherList.add(weather);

                }

                root.setName(nameRoot);
                root.setDate(dateRoot);
                root.setWeatherList(weatherList);

            }catch (Exception e){
                sendMessage("Невозможно открыть json, error = "+e.toString());
            }finally {
                if(fileReader!=null){
                    try{
                        fileReader.close();
                    }catch (IOException e){
                        sendMessage("невозможно закрыть filereader "+e.toString());
                    }

                }
            }
            return root;
        }
    else{
        return null;
    }
}
}

