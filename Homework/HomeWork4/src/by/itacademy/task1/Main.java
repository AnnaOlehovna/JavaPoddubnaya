package by.itacademy.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Введите количество пациентов");
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
               int amountOfPatient = bufferedReader.read();
        Patient[] patients = new Patient[amountOfPatient];
        for (int i = 0; i < patients.length; i++) {
            patients[i] = new Patient();
            System.out.println("Введите ФИО " + (i + 1) + "-го пациента");
            String a = bufferedReader.readLine();
            patients[i].setFullName(a);
            System.out.println("Введите возраст " + (i + 1) + "-го пациента");
            patients[i].setAge(scanner.nextInt());
            System.out.println("Введите номер телефона " + (i + 1) + "-го пациента");
            patients[i].setPhoneNumber(scanner.next());
        }
        for (int i = 0; i < patients.length; i++) {
            System.out.println("Пациент: " + patients[i].getFullName() + " - Возраст: " + patients[i].getAge() + " лет.");
        }

    }

    public String addString(){
        String inputString=null;
        try{
           BufferedReader bebebe= new BufferedReader(new InputStreamReader(System.in));
          inputString = bebebe.readLine();
       }catch (IOException e){

       }
       return inputString;
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
