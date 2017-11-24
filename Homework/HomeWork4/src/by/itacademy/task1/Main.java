package by.itacademy.task1;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        System.out.println("Введите количество пациентов");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfPatient = reader;
        Patient[] patients = new Patient[amountOfPatient];
        for (int i = 0; i < patients.length; i++) {
            patients[i] = new Patient();
            System.out.println("Введите ФИО " + (i + 1) + "-го пациента");
            patients[i].setFullName(scanner.nextLine());//перескакивает не дождавшись ввода
            System.out.println("Введите возраст " + (i + 1) + "-го пациента");
            patients[i].setAge(scanner.nextInt());
            System.out.println("Введите номер телефона " + (i + 1) + "-го пациента");
            patients[i].setPhoneNumber(scanner.next());
        }
        for (int i = 0; i < patients.length; i++) {
            System.out.println("Пациент: " + patients[i].getFullName() + " - Возраст: " + patients[i].getAge() + " лет.");
        }

    }


    public static String searchByName() {
        System.out.println("Введите ФИО пациента");
        Scanner scanner = new Scanner(System.in);
        String patientName = scanner.next();
        return patientName;

    }



    public void goodbyeMessage() {
        System.out.println("Спасибо, что воспользовались нашими услугами! Всего доброго!");
    }

}
