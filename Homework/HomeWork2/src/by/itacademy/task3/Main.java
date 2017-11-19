package by.itacademy.task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] arg){

         /* 3. Напишите программу, которая печатает массив,
    затем инвертирует (то есть меняет местами первый элемент с последним,
    второй — с предпоследним и т.д.), и вновь печатает.        */

        int[] arrayForInverting = {1, 2, 3, 4, 5};
        int[] tempArray = new int[arrayForInverting.length];
        System.out.println(Arrays.toString(arrayForInverting));
        for (int i = 0; i < arrayForInverting.length; i++) {
            tempArray[i] = arrayForInverting[arrayForInverting.length - 1 - i];
        }
        System.out.println(Arrays.toString(tempArray));

    }
}
