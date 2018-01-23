package by.itacademy.Presentation;

import by.itacademy.Manager.Manager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Manager manager = Manager.getInstance();

        System.out.printf("Введите:\n1- чтобы скачать и распарсить XML\n2- чтобы скачать и распарсить JSON" +
                "\n3- чтобы выйти\nОтвет: ");
        Scanner scanner = new Scanner(System.in);
        manager.downloadingAndParsing(scanner.nextInt());






    }




    public void printMessages(String text){
        System.out.println(text);
    }
}
