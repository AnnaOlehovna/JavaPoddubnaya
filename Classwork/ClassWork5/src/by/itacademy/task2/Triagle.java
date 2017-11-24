package by.itacademy.task2;

/**
 * Created by user on 24.11.2017.
 */
public class Triagle extends Multiagle {

    private double a;
    private double h;

    public Triagle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public double getSqr() {
        double square = 0.5*a*h;
        return square;
    }
}
