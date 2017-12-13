package by.itacademy.task2;

import java.util.ArrayList;

public class Room implements LightInRoom,BusySquare{

    private static final int maxPercent= 70;

    private String roomName;
    private double roomSq;
    private double busySq;
    private int windows;
    private ArrayList<Lamp> lampList = new ArrayList<>();
    private ArrayList<Furniture> furnitureList = new ArrayList<>();
    private int light;

    public Room() {
    }

    public Room(String roomName, double roomSq, int windows) {
        this.roomName = roomName;
        this.roomSq = roomSq;
        this.windows = windows;
    }

    public static int getMaxPercent() {
        return maxPercent;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getRoomSq() {
        return roomSq;
    }

    public void setRoomSq(double roomSq) {
        this.roomSq = roomSq;
    }

    public double getBusySq() {
        return calculateBusySq();
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public ArrayList<Lamp> getLampList() {
        return lampList;
    }

    public void setLampList(ArrayList<Lamp> lampList) {
        this.lampList = lampList;
    }

    public ArrayList<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void setFurnitureList(ArrayList<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }

    public int getLight() {
        return calculateLight();
    }



    public void add(Lamp lamp)throws IlluminanceTooMuchException{
        if(getLight()+ lamp.getPower()>4000){
            throw new IlluminanceTooMuchException();
        }else{
            lampList.add(lamp);
        }
    }

    public void add(Furniture furniture) throws SpaceUsageTooMuchException{
        if(getBusySq()+furniture.getSize()>maxPercent*roomSq/100){
            throw new SpaceUsageTooMuchException();
        }else{
            furnitureList.add(furniture);
        }
    }



    @Override
    public int calculateLight() {
     int lampLight = 0;
      for(int i = 0; i< lampList.size(); i++){
          lampLight=lampLight+lampList.get(i).getPower();
      }
        light= getWindows()* 700 + lampLight;
        return light;
    }

    @Override
    public double calculateBusySq() {
        for(int i = 0; i<furnitureList.size();i++){
            busySq=busySq+furnitureList.get(i).getSize();
        }
        return busySq;
    }

    public double calculateFreeSq() {
        double freeSq = roomSq-busySq;
        return freeSq;
    }


    public void describeLight(){
        if(lampList.size()==0){
            System.out.printf("- нет)\r\n");
        }else{

        for(int i=0; i<lampList.size();i++){
            System.out.printf(lampList.get(i).getPower()+" ЛК");
            if(i==lampList.size()-1){
                System.out.printf(")\r\n");
            }else{
                System.out.printf(", ");
            }
        }
        }
    }

    public void describeFurniture(){
        if(furnitureList.size()==0){
            System.out.printf("нет");
        }else{
        for(int i=0; i<furnitureList.size();i++){

            System.out.println(furnitureList.get(i).getName()+" (площадь "+furnitureList.get(i).getSize()+" м.кв.)");
        }
        }
    }


}
