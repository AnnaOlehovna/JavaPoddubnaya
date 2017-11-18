package by.itacademy.task1;

import java.util.Scanner;

public class Main {


    public static void main(String[] arg) {
        int[] currentArray = getTenNumbers();
        printArray(currentArray);

    }

    public static int[] getTenNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] arrayOfTenNumbers = new int[10];
        for (int i = 0; i < arrayOfTenNumbers.length; i++) {
            System.out.println("Введите " +(i+1)+ "-ое целое число");
            int number = scanner.nextInt();
            arrayOfTenNumbers[i] = number;
        }
        return arrayOfTenNumbers;
    }

    public static void printArray(int[] arrayForPrinting) {
        int[] tempArray = arrayForPrinting;
        for (int i = 0; i < tempArray.length; i++) {
            System.out.print(tempArray[i] + " | ");
        }
    }


}
