package by.itacademy.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        MyThread myThread1 = new MyThread();
        myThread1.setName("myThread1");
        MyThread myThread2 = new MyThread();
        myThread2.setName("myThread2");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите \"start\"");
        try {
            String startConsole = bf.readLine().toLowerCase();
            if( startConsole.equals("start")){
                myThread1.start();
                myThread2.start();
            }else{
                System.out.println("Неверный ввод");
            }
        } catch (IOException e) { }

    }


    public synchronized int print10(int counter){
        System.out.printf("\n"+Thread.currentThread().getName());
            for (int j = 0; j < 10; j++) {
                System.out.printf(" "+counter+" ");
                counter++;
            }
        return counter;
    }
}
