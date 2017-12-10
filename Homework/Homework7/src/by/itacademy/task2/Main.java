package by.itacademy.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        Student[] stud = addStudents();
        Manager manager= new Manager(stud);
        printStud(stud);
        printAverageAge(manager.averageAge(stud));

    }

    /**
     Считывает строку с консоли
     *
     * @return String
     */
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

    /**
     * Считывает целое число с консоли
     *
     * @return int
     */
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

    /**
     *
     * @return
     */
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

    /**
     * Печатает в консоль массив Student[]
     *
     * @param students - тип Student[]
     */
    public static void printStud(Student[] students){
        for(int i =0; i<students.length;i++){
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(students[i].getSurName()+" "+ students[i].getName()+" "+ sdf.format(students[i].getBirthDay()));
        }
    }

    /**
     * Печатает в консоль средний возраст студентов
     *
     * @param yearMonth - тип int[] - год и месяц
     */
    private static void printAverageAge(int[] yearMonth){
       String s1=null;
       String s2=null;
        if(yearMonth[0]%10==1){
            s1 = "Средний возраст студентов: "+yearMonth[0]+" год ";
        }else if(yearMonth[0]%10==2||yearMonth[0]%10==3||yearMonth[0]%10==4){
            s1= "Средний возраст студентов: "+yearMonth[0]+" года ";
        }else{
            s1="Средний возраст студентов: "+yearMonth[0]+" лет ";
        }
        if(yearMonth[1]==0){
            s2="";
        }else if(yearMonth[1]==2||yearMonth[1]==3||yearMonth[1]==4){
            s2= yearMonth[1]+" месяца.";
        }else{
            s2=yearMonth[1]+ " месяцев.";
        }
        System.out.println(s1+s2);

    }


}
