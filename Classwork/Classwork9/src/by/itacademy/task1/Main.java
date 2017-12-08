package by.itacademy.task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ArrayList<String> array = new ArrayList<>();
        array.add("11111");
        array.add("54332");
        array.add("8796");
        array.add("799");


        System.out.println("Размер листа "+array.size());

        array.add("98756");

        System.out.println("Размер листа "+array.size());

        System.out.println( array.get(0));

        array.remove(2);
        System.out.println("Размер листа "+array.size());

        //добавляет значение в индекс 3, а остальное - сдвигает вправо
        array.add(3,"0200033135");

        //заменяет значение в индексе 2 на новое
        array.set(2,"34567");


        //двухсвязанный список -  каждый элемент имеет ссылку на предыдущий и следующий элемент
        LinkedList<String> linkArray  = new LinkedList<>();


        List<Student> arrayStudent = new ArrayList<>();
        boolean isAdded = true;

        while(isAdded == true){
            System.out.println("Введите имя студента ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            System.out.println("Введите возраст студента ");
            int age = scanner.nextInt();
            Student student = new Student(name,age);
            arrayStudent.add(student);
            System.out.println("Если хотите добавить еще одного студента нажмите 1, если хотите выйти нажмите другую цифру ");
            int tmp = scanner.nextInt();
            if(tmp!=1){
                isAdded=false;
            }
        }

        for(Student student:arrayStudent){
            System.out.println("name "+student.getName());
            System.out.println("age "+student.getAge());

        }
        System.out.println(arrayStudent.toString());


        Student student1= new Student("Name",25);
        Student student2= new Student("Name",25);

        System.out.println(student2.toString());









    }
}
