package by.itacademy.task2;

public class Table extends Furniture {


    public Table(String name, double minSize, double maxSize) {
        super(name, minSize, maxSize);
    }

    public Table(String name, double maxSize) {
        super(name, maxSize);
    }
}
