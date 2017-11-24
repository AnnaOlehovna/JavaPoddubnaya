package by.itacademy.task2;

import javafx.scene.shape.*;

import java.awt.*;

/**
 * Created by user on 24.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        Multiagle shape = null;
        int input = 1;
        switch (input) {
            case 1: {
                shape = new Rectagle(10, 4);
                break;
            }
            case 2: {
                shape = new Square(5);
                break;
            }
            default: {
                System.out.println("Такой фигуры нет");
            }
        }

        printShapeSquare(shape);
    }

    private static void printShapeSquare(Multiagle shape) {
        System.out.println("Площадь фигуры " + shape.getSqr());
        if (shape instanceof Multiagle) {
            System.out.println("фигура0");
        } else if (shape instanceof Rectagle) {
            System.out.println("прямоугольник");
        }

    }

}
