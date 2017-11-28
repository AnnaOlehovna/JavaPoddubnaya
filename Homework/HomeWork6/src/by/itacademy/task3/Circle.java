package by.itacademy.task3;

public class Circle implements Shape {

   private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateSq() {
        double circleSq = Math.PI*radius;
        return circleSq;
    }
}
