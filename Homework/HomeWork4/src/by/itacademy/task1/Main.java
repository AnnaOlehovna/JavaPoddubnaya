package by.itacademy.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Введите количество пациентов");
        int amountOfPatient = addInt();
        Patient[] patients = new Patient[amountOfPatient];
        for (int i = 0; i < patients.length; i++) {
            patients[i] = new Patient();
            System.out.println("Введите ФИО " + (i + 1) + "-го пациента");
             patients[i].setFullName(addString());
            System.out.println("Введите возраст " + (i + 1) + "-го пациента");
            patients[i].setAge(addInt());
            System.out.println("Введите номер телефона " + (i + 1) + "-го пациента");
            patients[i].setPhoneNumber(addString());
        }
        for (int i = 0; i < patients.length; i++) {
            System.out.println("Пациент: " + patients[i].getFullName() + " - Возраст: " + patients[i].getAge() + " лет.");
        }

    }

    public static String addString(){
        String inputString=null;
        try{
           BufferedReader fillInString= new BufferedReader(new InputStreamReader(System.in));
          inputString = fillInString.readLine();
       }catch (IOException e){

       }
       return inputString;
    }

    public static int addInt(){
        int inputInt=0;
        try{
            BufferedReader fillInInt= new BufferedReader(new InputStreamReader(System.in));
            inputInt = fillInInt.read();
        }catch (IOException e){

        }
        return inputInt;
    }




    public static String searchByName() {
        System.out.println("Введите ФИО пациента");
        String patientName = addString();
        return patientName;
    }


    public void goodbyeMessage() {
        System.out.println("Спасибо, что воспользовались нашими услугами! Всего доброго!");
    }

}
