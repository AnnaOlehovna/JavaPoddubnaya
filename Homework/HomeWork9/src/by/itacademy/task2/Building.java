package by.itacademy.task2;

import java.util.ArrayList;

public class Building {
    private String buildingName;
    private ArrayList<Room> roomList = new ArrayList<>();


    public Building(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void addRoom(String roomName, double roomSq, int windows) {
        Room room = new Room(roomName,roomSq,windows);
        roomList.add(room);
    }

    public Room getRoom(String nameRoom) throws NoSuchRoomException {
        int index = -1;
        for (int i = 0; i < roomList.size(); i++) {
            if (nameRoom.equals(roomList.get(i).getRoomName())) {
                index = i;
            }
        }
        if (index == -1) {
            throw new NoSuchRoomException();
        }
        return roomList.get(index);

    }


    public void describe(){
        System.out.println(buildingName);
        for(int i=0; i<roomList.size();i++){
            System.out.printf(roomList.get(i).getRoomName()+"\r\n");
            System.out.printf("Освещенность = "+roomList.get(i).getLight()+" ЛК. " +
                    "("+roomList.get(i).getWindows()+" окна по 700 ЛК, " +
                    "лампочки ");
            roomList.get(i).describeLight();
            System.out.println("Площадь = "+roomList.get(i).getRoomSq()+" м.кв. "+
            "Занято = "+roomList.get(i).getBusySq()+" м.кв, гарантированно свободно "+roomList.get(i).calculateFreeSq()+
            " м.кв или "+ (100*roomList.get(i).calculateFreeSq()/roomList.get(i).getRoomSq())+" площади") ;
            System.out.println("Мебель: ");
            roomList.get(i).describeFurniture();
        }
    }

}

