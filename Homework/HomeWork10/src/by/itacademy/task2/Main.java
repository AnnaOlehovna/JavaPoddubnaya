package by.itacademy.task2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<FIO> men = new ArrayList<>();
        men.add(new FIO("Петров", "Сергей","Александрович"));
        men.add(new FIO("Иванов", "Олег","Валентиновичч"));
        men.add(new FIO("Смирнов", "Александр","Семенович"));
        men.add(new FIO("Жуков", "Игорь","Артемович"));
        men.add(new FIO("Мычко", "Алексей","Владимирович"));

        ArrayList<FIO> women = new ArrayList<>();
        women.add(new FIO("Ручец", "Анастасия","Владимировна"));
        women.add(new FIO("Суша", "Юлия","Олеговна"));
        women.add(new FIO("Даманова", "Елена","Олеговна"));
        women.add(new FIO("Троцкая", "Дарья","Павловна"));
        women.add(new FIO("Калугина", "Людмила","Прокофьевна"));

        HashMap<String,ArrayList> hashMap= new HashMap<>();
        hashMap.put("муж",men);
        hashMap.put("жен",women);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Чтобы получить ФИО введите: муж - если мужское или жен - если женское");
        String index = scanner.next();


    }
}
