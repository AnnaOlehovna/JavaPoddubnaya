package by.itacademy.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        Manager manager= new Manager();
        Manager[] stud = new Manager[2];
        printAverageAge(manager.averageAge(stud));





























    }


    public static String addString() {
        String inputString = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            e.getMessage();
        }
        return inputString;
    }

    public static int addInt() {
        int inputInt = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputInt = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.getMessage();
        }
        return inputInt;
    }

    public static Student[] addStudents() {
        Manager manager= new Manager();
        System.out.println("Введите число студентов");
        Student[] students = new Student[addInt()];
         for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            System.out.println("Введите Фамилию " + (i + 1) + " студента");
            students[i].setSurName(addString());
            System.out.println("Введите Имя " + (i + 1) + " студента");
            students[i].setName(addString());
            System.out.println("Введите дату рождения " + (i + 1) + " студента в формате дд-мм-гггг");
            students[i].setBirthDay(manager.stringToDate(addString()));
        }
        return students;
    }

    public static void printStud(Student[] students){
        for(int i =0; i<students.length;i++){
            System.out.println(students[0].getSurName()+" "+ students[0].getName()+" "+ students[0].getBirthDay());
        }
    }

    private static void printAverageAge(int[] yearMonth){
        System.out.println("Средний возраст студентов: "+yearMonth[0]+" лет "+yearMonth[1]+" месяцев.");
    }


}
