package by.itacademy.task3;

public class Triangle implements Shape{

    private double aSide;
    private double height;

    public Triangle(double aSide, double height) {
        this.aSide = aSide;
        this.height = height;
    }

    @Override
    public double calculateSq() {
        double triangleSq=0.5*aSide*height;
        return triangleSq;
    }


}
