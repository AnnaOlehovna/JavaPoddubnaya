package by.itacademy.presentation;

import by.itacademy.manager.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MyUI implements UIInterface {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void startUI() {

        System.out.printf("\n\t\tДОБРО ПОЖАЛОВАТЬ!\nВведите:\n1- чтобы скачать и распарсить XML\n2- чтобы скачать и распарсить JSON" +
                "\n3- чтобы выйти\nОтвет: ");

        Manager.getInstance().downloadingAndParsing(scanner.next());

    }

    @Override
    public void Menu() {
        System.out.printf("\n\t\tМЕНЮ\nВведите:" +
                "\n1- если хотите вывести погоду на экран" +
                "\n2- если хотите осуществить поиск" +
                "\n3- если хотите отсортировать данные" +
                "\n4- если хотите получить средннюю или максимальную температуру по региону" +
                "\n5- чтобы выйти\nОтвет: ");
        String choiceOne = scanner.next();
        switch (choiceOne) {
            case "1":
                outputWeatherUI();
                break;
            case "2":
                searchUI();
                break;
            case "3":
                sortUI();
                break;
            case "4":
                tempInRegionUI();
                break;
            case "5":
                goodByeMessage();
                break;
            default:
                System.out.println("Неверный ввод! Попробуйте еще раз");
                Menu();
                break;

        }
    }

    @Override
    public void outputWeatherUI() {
        System.out.printf("\n\t\tВЫВОД ПОГОДЫ НА ЭКРАН\nВведите:\n1- чтобы вывести погоду за весь период" +
                "\n2- чтобы вывести погоду за определенную дату" +
                "\n3- чтобы вывести погоду за период" +
                "\n4- чтобы вернуть назад к МЕНЮ" +
                "\n5- чтобы выйти\nОтвет: ");
        Manager.getInstance().showRootAccordingDates(scanner.next());
    }

    @Override
    public void searchUI() {
        System.out.printf("\n\t\tПОИСК\nВведите:\n1- поиск по определенному городу" +
                "\n2- поиск городов по диапазону температур" +
                "\n3- чтобы вернуть назад к МЕНЮ" +
                "\n4- чтобы выйти" +
                "\nОтвет: ");
        Manager.getInstance().searching(scanner.next());

    }

    @Override
    public void sortUI() {
        System.out.printf("\n\t\tСОРТИРОВКА ДАННЫХ\nВведите:\n1- чтобы сортировать данные по влажности" +
                "\n2- чтобы сортировать данные по максимальной температуре" +
                "\n3- чтобы сортировать данные по минимальной температуре" +
                "\n4- чтобы вернуть назад к МЕНЮ" +
                "\n5- чтобы выйти\nОтвет: ");
        Manager.getInstance().sorting(scanner.next());
    }


    @Override
    public void tempInRegionUI() {
        System.out.printf("\n\t\tТЕМПЕРАТУРА ПО РЕГИОНУ\nВведите:\n1- чтобы узнать максимальную температуру по каждому региону" +
                "\n2- чтобы узнать среднюю температуру по каждому региону" +
                "\n3- чтобы вернуть назад к МЕНЮ" +
                "\n4- чтобы выйти" +
                "\nОтвет: ");
        Manager.getInstance().tempInRegion(scanner.next());
    }

    public void goodByeMessage() {
        System.out.printf("ВСЕГО ДОБРОГО!");
    }


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


    public int askForTempMin() {
        System.out.println("Введите МИНимальную температуру");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public int askForTempMax() {
        System.out.println("Введите МАКСимальную температуру");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public String askForData() {
        System.out.println("Введите дату в формате дд-мм-гггг. Например: 22-10-2015");
        String dateToFind = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            dateToFind = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dateToFind;
    }


    public void askForRepeat() {
        System.out.printf("\nХотите вернуться в МЕНЮ? Введите:" +
                "\n1- Да\n2- Нет\nОтвет:");
        String choice = scanner.next();
        switch (choice) {
            case "1":
                Menu();
                break;
            case "2":
                goodByeMessage();
                break;
            default:
                System.out.printf("\nНеверный ввод! Попробуйте еще раз!");
                askForRepeat();
                break;
        }

    }


    public void printMessages(String text) {
        System.out.println(text);
    }
}
