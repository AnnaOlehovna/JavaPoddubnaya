package by.itacademy.test3;

import sun.security.provider.SHA;

/**
 * Created by user on 27.11.2017.
 */
public class Main {
    public static void main(String[] args) {


        Shape shape;
        shape = new Triangle();
        shape.getStr();

        printShape(shape);


        Triangle triangle = new Triangle();

        printShape(triangle);
        printTriangleSpec(triangle);


    }

    private static void printShape(Shape shape) {

    }

    private static void printTriangleSpec(TriangleSpecific triangleSpecific) {

    }

}
