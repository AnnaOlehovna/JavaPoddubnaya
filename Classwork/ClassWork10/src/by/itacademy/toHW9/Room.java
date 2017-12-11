package by.itacademy.toHW9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11.12.2017.
 */
public class Room {

    private static final int maxPercent= 70;
    private double roomsq;
    private double busySq;
    private String nameRoom;
    private int numberWindows;
    private List<Lamp> lampList = new ArrayList<>();
    private List<Furniture> furnitureList = new ArrayList<>();




    public double getRoomsq() {
        return roomsq;
    }

    public void setRoomsq(double roomsq) {
        this.roomsq = roomsq;
    }

    public double getBusySq() {
        return busySq;
    }

    public void setBusySq(double busySq) {
        this.busySq = busySq;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public int getNumberWindows() {
        return numberWindows;
    }

    public void setNumberWindows(int numberWindows) {
        this.numberWindows = numberWindows;
    }

    public void addLamp(Lamp lamp){
        //проверить в каких рамках освещенность, и проверить можно ли еще лампочку - если превышает - то экспепшн
        lampList.add(lamp);

    }

    public void addFurniture(Furniture furniture){
        //Проверить здесь влазит ли мебель и выкидывает исключение

        furnitureList.add(furniture);

    }

}
