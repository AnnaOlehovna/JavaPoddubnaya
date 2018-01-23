package by.itacademy.DownloadAndParsing;

import by.itacademy.Entity.City;
import by.itacademy.Entity.Root;
import by.itacademy.Entity.Weather;
import by.itacademy.Manager.ConvertDate;
import by.itacademy.Manager.EventManager;
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
 * Parsing data from JSON to Entity
 */
public class ParseJSON extends EventManager implements Parsing {


    ConvertDate convertDate = new ConvertDate();


    @Override
    public void parsingFile(File file) {

            JSONParser parser = new JSONParser();

            FileReader fileReader = null;

            try{
                Root root = new Root();
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

                    for (int i = 0; i < locationListJson.size() ; i++) {

                        String string = (String) locationListJson.get(i);
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
                    Weather weather = new Weather(date,description,(int)humidity,(int)id,locationMap,(int)tempMin,(int)tempMax,title);
                    weatherList.add(weather);

                }

                root.setName(nameRoot);
                root.setDate(dateRoot);
                root.setWeatherList(weatherList);


                System.out.println(root.toString());

            }catch (Exception e){
                System.out.println("Невозможно открыть json, error = "+e.toString());
            }finally {
                if(fileReader!=null){
                    try{
                        fileReader.close();
                    }catch (IOException e){
                        System.out.println("невозможно закрыть filereader "+e.toString());
                    }

                }
            }
        }


}

