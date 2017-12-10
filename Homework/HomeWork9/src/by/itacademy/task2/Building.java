package by.itacademy.task2;

public class Building {
    private String buildingName;
    private Room room;


    public Building(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room addRoom(String roomName, double square, int windows){
        Room room = new Room(roomName,square,windows);
        return room;
    }
}

