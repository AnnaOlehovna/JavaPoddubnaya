package by.itacademy.task3;

public class Triangle implements Shape{

    private double aSide;
    private double bSide;
    private double angle;

    public Triangle(double aSide, double bSide, double angle) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.angle = angle;
    }

    @Override
    public double calculateSq() {
        double triangleSq=0.5*aSide*bSide*Math.sin(angle);
        return triangleSq;
    }


}
