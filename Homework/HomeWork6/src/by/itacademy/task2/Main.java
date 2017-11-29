package by.itacademy.task2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {



        int[] arrayInitial = fillInArray(6);
        System.out.println(Arrays.toString(arrayInitial));

        int[] arrayFinal = fillInArray(12);
        System.out.println(Arrays.toString(arrayFinal));

        int[] copiedArray = arrayWithCopy(arrayInitial,arrayFinal);
        System.out.println(Arrays.toString(copiedArray));

    }

    /**
     * Create int array with random numbers from 0 to 100
     * @param arraySize - size of array
     * @return
     */
    public static int[] fillInArray(int arraySize){
        Random random = new Random();
    int[] array = new int[arraySize];
        for(int i=0; i<array.length; i++){
            array[i]=random.nextInt(100);
        }
    return array;
    }

    /**
     * Copies a smaller array of integer in the middle of the bigger array of integer
     * @param smallerArray
     * @param biggerArray
     * @return
     */
    public static int[] arrayWithCopy(int[] smallerArray, int[] biggerArray){
     int halfSmaller = smallerArray.length/2;
     int halfBigger = biggerArray.length/2;
     int indexBegin = halfBigger-halfSmaller;
     System.arraycopy(smallerArray,0,biggerArray,indexBegin,smallerArray.length);
    return biggerArray;
    }
}
