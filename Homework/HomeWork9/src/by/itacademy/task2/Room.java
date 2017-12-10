package by.itacademy.task2;

import java.util.ArrayList;

public class Room implements LightInRoom,BusySquare{
    private String roomName;
    private double squareRoom;
    private double minBusySquare;
    private double maxBusySquare;
    private int windows;
    private ArrayList<Bulb> bulb;
    private ArrayList<Furniture> furniture;
    private int light;

    public Room(String roomName, double square, int windows) {
        this.roomName = roomName;
        this.squareRoom = square;
        this.windows = windows;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getSquare() {
        return squareRoom;
    }

    public void setSquare(double square) {
        this.squareRoom = square;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public ArrayList<Bulb> getBulb() {
        return bulb;
    }

    public void setBulb(ArrayList<Bulb> bulb) {
        this.bulb = bulb;
    }

    public ArrayList<Furniture> getFurniture() {
        return furniture;
    }

    public void setFurniture(ArrayList<Furniture> furniture) {
        this.furniture = furniture;
    }

    public int getLight() {
        return light;
    }
    public void setLight(int light) {
        this.light = light;

    }


    public double getMaxBusySquare() {
        return maxBusySquare;
    }

    public void setMaxBusySquare(double maxBusySquare) {
        this.maxBusySquare = maxBusySquare;
    }

    public double getMinBusySquare() {
        return minBusySquare;
    }

    public void setMinBusySquare(double minBusySquare) {
        this.minBusySquare = minBusySquare;
    }

    public void add(Bulb bulb)throws IlluminanceTooMuchException{
        if(getLight()+bulb.getPower()>4000){
            throw new IlluminanceTooMuchException();
        }
    }

    public void add(Furniture furniture) throws SpaceUsageTooMuchException{


    }



    @Override
    public int calculateLight() {
     int bulbLight = 0;
      for(int i = 0;i<bulb.size();i++){
          bulbLight=+bulb.get(i).getPower();
      }
        light= getWindows()* 700 + bulbLight;
        return light;
    }

    @Override
    public double calculateMaxBusySquare() {
        for(int i=0; i<furniture.size();i++){
            maxBusySquare =+ furniture.get(i).getMaxSize();
        }
        return maxBusySquare;
    }


}
