package task1;

import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        //вариант 1
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < number; i++) {
            int currentNumber = scanner.nextInt();
            if (hashMap.containsKey(currentNumber)) {
                int value = hashMap.get(currentNumber);
                value++;
            } else {
                hashMap.put(currentNumber, 1);
            }
        }

        //тут нужно получить ключ которому соответсвует значение 1
        System.out.println(hashMap.containsValue(1));

        //второй вариант
        int[] array={1,2,3,2,3};
        System.out.println(getNumber(array));


    }



    public static int getNumber(int[] array){
        int result = 0;
        for(int i=0; i<array.length;i++){
            result=result^array[i];
        }
        return result;
    }
}
