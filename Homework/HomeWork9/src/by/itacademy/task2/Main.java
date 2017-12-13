package by.itacademy.task2;

public class Main {
    public static void main(String[] args) {

        Building building1 = new Building("Здание 1");
        building1.addRoom("Комната 1", 100, 3);
        building1.addRoom("Комната 2", 5, 2);
        try {
            try {
                building1.getRoom("Комната 1").add(new Lamp(150));
            } catch (IlluminanceTooMuchException e) {
                System.out.println(e.getMessage());
            }

            try {
                building1.getRoom("Комната 1").add(new Lamp(250));
            } catch (IlluminanceTooMuchException e) {
                System.out.println(e.getMessage());
            }

            try {
                building1.getRoom("Комната 1").add(new Table("Стол письменный", 3));
            } catch (SpaceUsageTooMuchException e) {
                System.out.println(e.getMessage());
            }

            try {
                building1.getRoom("Комната 1").add(new Armchair("Кресло мягкое", 10));
            } catch (SpaceUsageTooMuchException e) {
                System.out.println(e.getMessage());
            }

        } catch (NoSuchRoomException e) {
            System.out.println(e.getMessage());
        }

        building1.describe();

    }




}
