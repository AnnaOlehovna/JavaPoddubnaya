package by.itacademy.task1.EntityJSON;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by user on 18.12.2017.
 */
public class DateGsonConvert implements JsonDeserializer<Date>{

    private final String[] formats  = new String[]{
            "yyyy-MM-dd HH:mm", "yyyy-MM-dd"
    };


    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        for(String format: formats){
            try{
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                return sdf.parse(jsonElement.getAsString());


            }catch (Exception e){

            }
        }

        return null;
    }
}
