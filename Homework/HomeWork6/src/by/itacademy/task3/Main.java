package by.itacademy.task3;

public class Main {
    public static void main(String[] args) {

        Shape shape;
        shape=new Triangle(4,5);
        System.out.println(shape.calculateSq());

        shape=new RightTriangle(4,(Math.PI)/6);
        System.out.println(shape.calculateSq());

    }
}
