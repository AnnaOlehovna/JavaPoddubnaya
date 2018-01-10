package task2;

/**
 * Created by user on 09.01.2018.
 */
public class Main {

    private static Object object = new Object();
    public static void main(String[] args) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
                main.print10();
            }
        });


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
                main.print10();
            }
        });


        thread.start();
        thread1.start();
    }



    //если нет перед в synchronized еще и static - то блокировка доступа на уровне объекта происходит,
    // поэтому объект можно создать до создания потоков, чтобы обращаться к одному объекту
    //а если есть static - то блокировка на уровне класса

    public  void print10(){

    //    synchronized (Main.calss) - это как  static synchronized для Main - для всего класса
        synchronized (object){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " i= " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
        }
    }
}
