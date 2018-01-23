package by.itacademy.presentation;

import by.itacademy.DownloadAndParsing.ParseJSON;
import by.itacademy.Manager;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Manager manager = Manager.getInstance();

        System.out.printf("Введите:\n1- чтобы скачать и распарсить XML\n2- чтобы скачать и распарсить JSON" +
                "\n3- чтобы выйти\nОтвет: ");
        Scanner scanner = new Scanner(System.in);
        int choice=scanner.nextInt();
        manager.downloadingAndParsing(choice);






    }



    public void printMessages(String text){
        System.out.println(text);
    }
}
