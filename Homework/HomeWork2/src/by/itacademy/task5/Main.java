package by.itacademy.task5;

import java.util.Arrays;

public class Main {
    public static void main(String[] arg) {
          /*5.Создайте массив типа int. Отсортируйте массив любым способом
        (по убыванию либо по возрастанию). Результат вывести на экран.
         */
        System.out.println("****************");
        int[] arrayForSorting = {2, 7, 9, 3,8,0};
        Arrays.sort(arrayForSorting);
        for (int i = 0; i < arrayForSorting.length; i++) {
            System.out.print("[" + arrayForSorting[i] + "]");

        }
    }
}

