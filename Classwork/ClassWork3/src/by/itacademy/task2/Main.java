package by.itacademy.task2;

import java.util.Scanner;

/**
 * для интерфейса библиотека Swing
 */
public class Main {

    public static void main(String[] arg) {

//        int a = 0;
//        int b = 0;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите а ");
//        a = scanner.nextInt();
//        System.out.println("Введите b ");
//        b = scanner.nextInt();
//
//        System.out.println(a + b);
//
        int result= plus(10,15);
        System.out.println(result);


        String resultik = plusik();
        System.out.println(resultik);

    }

    public static void printArray(String[] array) {
        System.out.println(array);
    }

    public static int plus(int c, int d) {
        int sum=c+d;
        return sum;

    }

    public static void fefefe(){
        if(true){
            return;
        }//сделает выход из метода и не будет продолжать, а break - только из цикла или условия
    }


    public static String plusik(){
        String a ="piy-piy";
        return a;
    }
}
