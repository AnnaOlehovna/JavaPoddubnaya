package by.itacademy.task1;

import by.itacademy.task1.Factories.ChemistryFactory;
import by.itacademy.task1.Factories.FactoryInterface;
import by.itacademy.task1.Factories.MathFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Application app;
        FactoryInterface factoryInterface;
        System.out.println("Введите 1, чтобы выбрать курсы математики и другое число, чтобы выбрать курсы химии");
        Scanner  scanner = new Scanner(System.in);

        if(scanner.nextInt()==1){
            factoryInterface = new MathFactory();
        }else {
            factoryInterface = new ChemistryFactory();
        }
        app = new Application(factoryInterface);

        app.getLesson().chooseTheLesson();
        app.getBook().buyBook();

    }

}
