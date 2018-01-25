package by.itacademy.Presentation;

import by.itacademy.Manager.Manager;


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

        System.out.printf("Введите:\n1- если хотите вывести погоду на экран\n2- если хотите осуществить поиск" +
                "\n3- если хотите отсортировать данные\n4- если хотите получить средннюю или максимальную температуру по региону\n5- чтобы выйти\nОтвет: ");
        int choiceOne = scanner.nextInt();
        switch (choiceOne) {
            case 1:
                //написать логику
                break;
            case 2:
                System.out.printf("\n\t\tПОИСК" + "\nВведите:\n1- поиск по определенному городу" +
                        "\n2- поиск городов по диапазону температур\n3- чтобы выйти\nОтвет: ");
                manager.searching(scanner.nextInt());
                break;
            case 3:
                System.out.printf("Введите:\n1- чтобы сортировать данные по влажности\n2- чтобы сортировать данные по максимальной температуре" +
                        "\n3- чтобы сортировать данные по минимальной температуре\n4- чтобы выйти\nОтвет: ");
                manager.sorting(scanner.nextInt());
                break;
            case 4:
                //написать логику
                break;
            case 5:
                goodByeMessage();

        }


    }

    /**
     * Ask user to print name of City for Searching by city
     * @return String with name of the city
     */
    public String askForCity() {
        System.out.println("Введите название города для поиска информации. Например: Minsk");
        String cityToFind = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            cityToFind = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cityToFind;
    }

    /**
     * Ask user to print MIN temperature for Searching
     * by temperature range
     */
    public int askForTempMin() {
        System.out.println("Введите МИНимальную температуру");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * Ask user to print MAX temperature for Searching
     * by temperature range
     */
    public int askForTempMax() {
        System.out.println("Введите МАКСимальную температуру");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public void printMessages(String text) {
        System.out.println(text);
    }


    public static void goodByeMessage() {
        System.out.printf("Всего доброго!");
    }
}
