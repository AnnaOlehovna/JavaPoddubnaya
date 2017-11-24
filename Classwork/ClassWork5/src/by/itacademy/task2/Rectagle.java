package by.itacademy.task2;

/**
 * Created by user on 24.11.2017.
 */
public class Rectagle extends Multiagle {
    private double a;
    private double b;

    public Rectagle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getSqr() {
        double square = a*b;
        return square;
    }
}
