package by.itacademy.task3;

public class Rectangle implements Shape{
    private double aSide;
    private double bSide;

    public Rectangle(double aSide, double bSide) {
        this.aSide = aSide;
        this.bSide = bSide;
    }

    @Override
    public double calculateSq() {
        double rectangleSq=aSide*bSide;
         return rectangleSq;
    }
}
