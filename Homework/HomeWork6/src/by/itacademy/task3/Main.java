package by.itacademy.task3;

public class Main {
    public static void main(String[] args) {

        Shape shape;
        shape=new Triangle(4,5,Math.PI/6);
        System.out.println(shape.calculateSq());

        shape = new Rectangle(6,7);
        System.out.println(shape.calculateSq());

        shape = new Square(8);
        System.out.println(shape.calculateSq());

        shape = new Circle(4);
        System.out.println(shape.calculateSq());

    }
}
