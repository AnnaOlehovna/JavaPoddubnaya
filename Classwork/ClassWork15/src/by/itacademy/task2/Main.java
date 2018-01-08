package by.itacademy.task2;


import java.util.concurrent.LinkedBlockingQueue;

public class Main {


    private static StringBuilder stringBuilder = new StringBuilder();
    private static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {




        System.out.println("start main");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    stringBuilder.append(i);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true);//бесконечный цикл, но объявляем thread2 как daemon
                }
        });
        thread2.setDaemon(true);//daemon-потоки будут жить пока мэйн-поток живет, и если остались только эти потоки - то они завершаться вместе с мэйн



        thread1.start();
        thread2.start();

        thread1.setPriority(Thread.MAX_PRIORITY);//приоритет потока - будет вызываться раньше по возможности, если есть другие потоки
        thread2.isAlive();//проверка работает ли поток или уже завершился




        System.out.println("end main");

    }

    public static void someMethod(){
        Thread.currentThread().getName(); // можно вызвать внутри метода и узнать какой поток вызывает метод
    }
}
