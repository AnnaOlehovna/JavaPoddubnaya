import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

       /* 1. Создайте массив с 10-ю переменными типа int.
       Используя оператор "for" найдите и выведите на экран наименьшее и наибольшее значение в массиве.
      min value =  "значение которое у вас получилось".
      max value =  "значение которое у вас получилось".
      Далее замените наименьшее значение на 0, а наибольшее значение на 99
       и выведите получившийся массив на экран в виде: [23, 0, 34, 99, 43534].*/

        int[] numbers = {13, 55, 84, 45, 78, 28, 9, 97, 36, 1};
        int minValue = numbers[0];
        int min = 0;
        int maxValue = numbers[0];
        int max = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
                min = i;
            }
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
                max = i;
            }
        }
        System.out.println("min value = "+minValue);
        System.out.println("max value = "+maxValue);
        numbers[min] = 0;
        numbers[max] = 99;
        System.out.println(Arrays.toString(numbers));

    }
}