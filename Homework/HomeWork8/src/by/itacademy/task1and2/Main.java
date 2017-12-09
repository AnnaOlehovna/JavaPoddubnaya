package by.itacademy.task1and2;

public class Main {
    public static void main(String[] args) {

        Calculate calculate = new Calculate();
        System.out.println("Введите число ");
        calculate.setNum1();
        System.out.println("Введите число ");
        calculate.setNum2();
        System.out.printf("Выберите операцию и нажмите:%n1 - для сложения" +
                "%n2 - для вычитания %n3 - для умножения %n4 - для деления%n");
        System.out.println("Результат: "+calculate.findResult());

    }


}
