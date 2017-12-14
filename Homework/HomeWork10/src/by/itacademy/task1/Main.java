package by.itacademy.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Создание и заполнение ArrayList
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isFill = true;
        do try {
            System.out.println("Введите строку для добавления в массив или q - для выхода");
            String str = reader.readLine();
            if(str.equals("q")){
                isFill=false;
                System.out.println("Заполнение завершено");
            }else{
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }while(isFill);

        //Печать list
        System.out.println(list.toString());

        //Удаление букв а(кирилица) из строк
        for(int i=0; i<list.size();i++){
            String str=list.get(i).replace("а","");
            list.set(i,str);
        }

        //Печать list без букв а ='(
        System.out.println(list.toString());


        Set<String> set = new HashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);

        System.out.println(list.toString());
    }
}

