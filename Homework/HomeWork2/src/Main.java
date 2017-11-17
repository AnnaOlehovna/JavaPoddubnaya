import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

       /* 1. Создайте массив с 10-ю переменными типа int.
       Используя оператор "for" найдите и выведите на экран наименьшее и наибольшее значение в массиве.
                min value =  "значение которое у вас получилось".
                max value =  "значение которое у вас получилось".
                Далее замените наименьшее значение на 0, а наибольшее значение на 99
                и выведите получившийся массив на экран в виде:[23, 0, 34, 99, 43534].*/

        int[] firstArray = {346, 298, 6, 86, 24, 3, 375, 27, 6089, 761};
        int minValue = firstArray[0];
        int minIndex = 0;
        int maxValue = firstArray[0];
        int maxIndex = 0;
        for (int i = 1; i < firstArray.length; i++) {
            if (minValue > firstArray[i]) {
                minValue = firstArray[i];
                minIndex = i;
            }
            if (maxValue < firstArray[i]) {
                maxValue = firstArray[i];
                maxIndex = i;
            }

        }
        System.out.println("min value = " + minValue);
        System.out.println("max value = " + maxValue);
        firstArray[minIndex] = 0;
        firstArray[maxIndex] = 99;
        System.out.println(Arrays.toString(firstArray));


       /* 2. Создайте массив с 10-ю переменными типа float. Далее найдите дубликаты и выведите их количество.
        Пример: есть массив {2, 3, 5, 7, 6, 5, 7, 3, 7, 20} - в данном массиве цифра 3 и 7 повторяются.
                В результате выполнения программы на экран должно вывести:
                [3] - повторений 2
                [7] - повторений 3*/
        System.out.println("*****************");

        int counter = 0;
        boolean isDuplicate = false;

        float[] secondArray = {5.0f, 6.0f, 5.0f, 3.0f, 9.0f, 9.0f, 9.0f, 7.0f, 9.0f, 4.0f};
        for (int i = 0; i < secondArray.length; i++) {

            for (int j = 0; j < secondArray.length; j++) {
                if (secondArray[i] == secondArray[j]) {
                    counter++;
                    if (i > j) {
                        isDuplicate = true;
                        break;
                    }
                }
            }
            if (counter > 1 && !isDuplicate) {
                System.out.println("[" + secondArray[i] + "] - повторений " + counter);
            }
            counter = 0;
            isDuplicate = false;
        }



    /* 3. Напишите программу, которая печатает массив,
    затем инвертирует (то есть меняет местами первый элемент с последним,
    второй — с предпоследним и т.д.), и вновь печатает.        */
        System.out.println("****************");
        int[] thirdArray = {1, 2, 3, 4, 5};
        int[] tempArray = new int[thirdArray.length];
        System.out.println(Arrays.toString(thirdArray));
        for (int i = 0; i < thirdArray.length; i++) {
            tempArray[i] = thirdArray[thirdArray.length - 1 - i];
        }
        System.out.println(Arrays.toString(tempArray));

       /* 4. Написать программу, определяющую, образуют ли цифры некоторого числа
       строго возрастающую последовательность. Например: 123 – образуют, 212 – не образуют.        */




        /*5.Создайте массив типа int. Отсортируйте массив любым способом
        (по убыванию либо по возрастанию). Результат вывести на экран.
         */


    }

}