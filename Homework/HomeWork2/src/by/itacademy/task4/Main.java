package by.itacademy.task4;

public class Main {
    public static void main(String[] arg){

         /* 4. Написать программу, определяющую, образуют ли цифры некоторого числа
       строго возрастающую последовательность.
       Например: 123 – образуют, 212 – не образуют.        */

        System.out.println("****************");
        int numberToCheck = 12;
        int divisionResult = numberToCheck;
        int numeralCounter = 0;
        int numerals = numberToCheck;
        boolean increaze = false;
        //считаем кол-во цифр, чтобы создать массив
        do {
            divisionResult = divisionResult / 10;
            numeralCounter++;
        }
        while (divisionResult > 1);
        if (divisionResult == 1) {
            numeralCounter++;
        }
        int[] array = new int[numeralCounter];
        //заполняем массив цифрами числа с конца
        for (int i = 0; i < numeralCounter; i++) {
            array[numeralCounter - i - 1] = numerals % 10;
            numerals = numerals / 10;
        }
        //проверяем возрастающую последовательность
        for (int i = 0; i < numeralCounter - 1; i++) {
            if ((array[i] + 1) == array[i + 1]) {
                increaze = true;
            } else {
                increaze = false;
                break;
            }
        }
        if (increaze == true) {
            System.out.println("Цифры числа " + numberToCheck + " образуют строго возрастающую последовательность");
        } else {
            System.out.println("Цифры числа " + numberToCheck + " НЕ образуют строго возрастающую последовательность");
        }

    }
}
