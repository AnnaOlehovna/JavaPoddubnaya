package by.itacademy.task1;

import java.util.Scanner;

public class Main {


    public static void main(String[] arg) {

        int[] currentArray = getTenNumbers();
        printArray(currentArray);

        int[] sortedBubble = bubbleSorting(currentArray);
        printArray(sortedBubble);

        int[] evenNumbers = findEvenNumbers(currentArray);
        printArray(evenNumbers);


    }

    /**
     * Get 10 integer numbers from user
     * @return
     */
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

    /**
     * Prints array of integer numbers
     * @param arrayForPrinting
     */
    public static void printArray(int[] arrayForPrinting) {
        int[] tempArray = arrayForPrinting;
        for (int i = 0; i < tempArray.length; i++) {
            if (i == tempArray.length - 1) {
                System.out.println(tempArray[i]);

            } else {
                System.out.print(tempArray[i] + " | ");
            }
        }
    }

    /**
     * Method for Bubble sorting of integer numbers
     * @param arrayForSorting
     * @return
     */
    public static int[] bubbleSorting(int[] arrayForSorting) {
        for (int i = arrayForSorting.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayForSorting[j] > arrayForSorting[j + 1]) {
                    int temp = arrayForSorting[j];
                    arrayForSorting[j] = arrayForSorting[j + 1];
                    arrayForSorting[j + 1] = temp;
                }
            }
        }
        return arrayForSorting;
    }

    /**
     * Creates array of even integer numbers from current array
     * @param arrayOfNumbers - current array
     * @return
     */
    public static int[] findEvenNumbers(int[] arrayOfNumbers) {
        int counterOfEvenNumbers = 0;
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] % 2 == 0) {
                counterOfEvenNumbers++;
            }
        }
        int[] onlyEvenNumbers = new int[counterOfEvenNumbers];
        int indexForEven = 0;
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] % 2 == 0) {
                onlyEvenNumbers[indexForEven] = arrayOfNumbers[i];
                indexForEven++;
            }
        }
        return onlyEvenNumbers;
    }
}
