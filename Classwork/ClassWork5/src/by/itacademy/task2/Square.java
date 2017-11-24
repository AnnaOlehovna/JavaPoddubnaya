package by.itacademy.task2;

/**
 * Created by user on 24.11.2017.
 */
public class Square extends Multiagle {
    private double a;

    public Square(double a) {
        this.a = a;
    }


    @Override
    public double getSqr() {
        double square = a*a;
        return square;
    }
}
