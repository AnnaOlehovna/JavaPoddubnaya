package by.itacademy.task2;

public class Furniture {
    private String name;
    private double minSize;
    private double maxSize;

    public Furniture(String name, double minSize, double maxSize) {
        this.name = name;
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    public Furniture(String name, double maxSize) {
        this.name = name;
        this.maxSize = maxSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinSize() {
        return minSize;
    }

    public void setMinSize(double minSize) {
        this.minSize = minSize;
    }

    public double getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(double maxSize) {
        this.maxSize = maxSize;
    }
}
