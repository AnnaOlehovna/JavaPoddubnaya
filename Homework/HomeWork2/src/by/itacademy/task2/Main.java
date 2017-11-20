package by.itacademy.task2;

public class Main {

    public static void main(String[] arg){
         /* 2. Создайте массив с 10-ю переменными типа float. Далее найдите дубликаты и выведите их количество.
        Пример: есть массив {2, 3, 5, 7, 6, 5, 7, 3, 7, 20} - в данном массиве цифра 3 и 7 повторяются.
                В результате выполнения программы на экран должно вывести:
                [3] - повторений 2
                [7] - повторений 3*/

        int counter = 0;
        boolean isDuplicate = false;

        float[] arrayForDuplicateFinding = {5.0f, 6.0f, 5.0f, 3.0f, 9.0f, 9.0f, 9.0f, 7.0f, 9.0f, 4.0f};
        for (int i = 0; i < arrayForDuplicateFinding.length; i++) {

            for (int j = 0; j < arrayForDuplicateFinding.length; j++) {
                if (arrayForDuplicateFinding[i] == arrayForDuplicateFinding[j]) {
                    counter++;
                    if (i > j) {
                        isDuplicate = true;
                        break;
                    }
                }
            }
            if (counter > 1 && !isDuplicate) {
                System.out.println("[" + arrayForDuplicateFinding[i] + "] - повторений " + counter);
            }
            counter = 0;
            isDuplicate = false;
        }

    }
}
