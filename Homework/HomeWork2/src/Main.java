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
        System.out.println("min value = " + minValue);
        System.out.println("max value = " + maxValue);
        numbers[min] = 0;
        numbers[max] = 99;
        System.out.println(Arrays.toString(numbers));

       /* 2. Создайте массив с 10-ю переменными типа float. Далее найдите дубликаты и выведите их количество.
        Пример: есть массив {2, 3, 5, 7, 6, 5, 7, 3, 7, 20} - в данном массиве цифра 3 и 7 повторяются.
        В результате выполнения программы на экран должно вывести:
        [3] - повторений 2
        [7] - повторений 3*/
        System.out.println("************");
        float[] secondArray = new float[10];
        secondArray[0] = 7.0f;
        secondArray[1] = 5.0f;
        secondArray[2] = 3.0f;
        secondArray[3] = 3.5f;
        secondArray[4] = 9.0f;
        secondArray[5] = 5.0f;
        secondArray[6] = 9.0f;
        secondArray[7] = 7.0f;
        secondArray[8] = 5.0f;
        secondArray[9] = 5.0f;

        float duplication = secondArray[0];
        int countOfDublication = 0;
        boolean find=false;

               for (int i = 0; i < secondArray.length; i++) {
            if (duplication == secondArray[i]) {
                countOfDublication++;
            }
        }
        System.out.println("["+duplication+"] - повторений "+countOfDublication);
              

    }
}