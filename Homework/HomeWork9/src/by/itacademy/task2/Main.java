package by.itacademy.task2;

public class Main {
    public static void main(String[] args) {

        Building building1 = new Building("Здание 1");
        Room room1 = building1.addRoom("Комната 1", 100,3);
        Room room2 = building1.addRoom("Комната 2", 5,2);

            room1.add(new Bulb(150));

            room1.add(new Bulb(250));

            room1.add(new Table("Стол письменный",3));

            room1.add(new Armchair("Кресло мягкое и пушистое", 1,2));

    }
}
