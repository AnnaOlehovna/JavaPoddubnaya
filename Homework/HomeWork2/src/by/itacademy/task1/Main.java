package by.itacademy.task1;

import java.util.Arrays;

public class Main {

    public static void main(String[] arg) {
         /* 1. Создайте массив с 10-ю переменными типа int.
       Используя оператор "for" найдите и выведите на экран наименьшее и наибольшее значение в массиве.
       min value =  "значение которое у вас получилось".
        max value =  "значение которое у вас получилось".
        Далее замените наименьшее значение на 0, а наибольшее значение на 99
         и выведите получившийся массив на экран в виде:[23, 0, 34, 99, 43534].*/

        int[] arrayForMaxMin = {346, 298, 6, 86, 24, 3, 375, 27, 6089, 761};
        int minValue = arrayForMaxMin[0];
        int minIndex = 0;
        int maxValue = arrayForMaxMin[0];
        int maxIndex = 0;
        for (int i = 1; i < arrayForMaxMin.length; i++) {
            if (minValue > arrayForMaxMin[i]) {
                minValue = arrayForMaxMin[i];
                minIndex = i;
            }
            if (maxValue < arrayForMaxMin[i]) {
                maxValue = arrayForMaxMin[i];
                maxIndex = i;
            }

        }
        System.out.println("min value = " + minValue);
        System.out.println("max value = " + maxValue);
        arrayForMaxMin[minIndex] = 0;
        arrayForMaxMin[maxIndex] = 99;
        System.out.println(Arrays.toString(arrayForMaxMin));
    }
}
