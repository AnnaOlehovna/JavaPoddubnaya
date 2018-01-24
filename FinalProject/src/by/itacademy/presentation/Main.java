package by.itacademy.Presentation;

import by.itacademy.Manager.Manager;
import by.itacademy.Search.SearchingByCity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Manager manager = Manager.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите:\n1- чтобы скачать и распарсить XML\n2- чтобы скачать и распарсить JSON" +
                "\n3- чтобы выйти\nОтвет: ");

        manager.downloadingAndParsing(scanner.nextInt());

//        System.out.printf("Введите:\n1- чтобы сортировать данные по влажности\n2- чтобы сортировать данные по максимальной температуре" +
//                "\n3- чтобы сортировать данные по минимальной температуре\n4- чтобы выйти\nОтвет: ");
     //   manager.sorting(scanner.nextInt());
      //  System.out.println(manager.getRoot().toString());
//        manager.searching();







    }


public String askForCity(){
    String cityToFind="";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
        cityToFind=br.readLine();
    } catch (IOException e) { }
    return cityToFind;
}

    public void printMessages(String text){
        System.out.println(text);
    }
}
