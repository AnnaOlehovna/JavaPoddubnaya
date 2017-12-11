package by.itacademy.toHW9;

import java.util.ArrayList;

/**
 * Created by user on 11.12.2017.
 */
public class Building {
    private String buildingName;
    ArrayList<Room> roomList = new ArrayList<>();



    public void addRoom(Room room){
        roomList.add(room);
    }
}
