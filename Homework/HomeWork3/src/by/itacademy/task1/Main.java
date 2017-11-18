package by.itacademy.task1;

import java.util.Scanner;

public class Main {


    public static void main(String[] arg) {
        int[] currentArray = getTenNumbers();
        printArray(currentArray);
        int[] sortedBubble = bubbleSorting(currentArray);
        printArray(sortedBubble);

    }

    public static int[] getTenNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] arrayOfTenNumbers = new int[10];
        for (int i = 0; i < arrayOfTenNumbers.length; i++) {
            System.out.println("Введите " + (i + 1) + "-ое целое число");
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
        System.out.println("");
    }

    public static int[] bubbleSorting(int[] arrayForSorting) {
        for (int i = arrayForSorting.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayForSorting[j] > arrayForSorting[j + 1]) {
                    int temp = arrayForSorting[j];
                    arrayForSorting[j] = arrayForSorting[j+1];
                    arrayForSorting[j+1] = temp;
                }
            }
        }
        return arrayForSorting;
    }


}
