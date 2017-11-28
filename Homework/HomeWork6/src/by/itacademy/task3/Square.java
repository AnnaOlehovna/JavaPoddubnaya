package by.itacademy.task3;

public class Square implements Shape{

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateSq() {
        double squareSq = Math.pow(side,2);
        return squareSq;
    }
}
