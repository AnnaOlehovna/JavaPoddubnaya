package by.itacademy.task2;

public class Armchair extends Furniture {


    public Armchair(String name, double minSize, double maxSize) {
        super(name, minSize, maxSize);
    }

    public Armchair(String name, double maxSize) {
        super(name, maxSize);
    }
}
