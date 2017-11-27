package by.itacademy.task1;

import java.util.Scanner;

/**
 * Created by user on 27.11.2017.
 */
public class Main {
    public static void main(String[] args) {

        Manager manager= new Manager();

        System.out.println("Введите команду");

        // создаем тестовых пациентов
        manager.createTestData();
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        switch (command){
            case 0:{
                //распечатываем всех пациентов
                Patient[] array = manager.getPatientArray();
                if(array.length>0){
                    printPatientArray(array);
                }
            }
        }


    }

    public static void printPatientArray(Patient[] patients){
        for(Patient patient: patients){
            System.out.println(patient.getName()+patient.getAge());
        }
    }
}
