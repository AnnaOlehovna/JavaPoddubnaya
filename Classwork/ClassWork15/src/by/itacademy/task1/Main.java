package by.itacademy.task1;


public class Main {
    public static void main(String[] args) {

        System.out.println("start main");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //всё что написано внутри этого метода run будет запупщено в другом потоке, если вызвать через .start()
                for (int i = 0; i < 10; i++) {
                    System.out.println("thread1 i= " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //всё что написано внутри этого метода run будет запупщено в другом потоке, если вызвать через .start()
                for (int i = 0; i < 10; i++) {
                    System.out.println("thread2 i= " + i);
                    test(); //будет вызвано в новом потоке, если через start()
                    try {
                        Thread.sleep(1200);
                    } catch (InterruptedException e) {
                    }
                }

            }
        });

        //другой способ через создание класса наследуемого от Thread
        Thread3 thread3 = new Thread3();
        Thread4 thread4 = new Thread4();



/*
        //.run() - код в методе run выполнится в том же потоке
        thread1.run();
*/
        //.start() - код в методе run выполнится в другом потоке
   /*     thread1.start();
        thread2.start();
        thread3.start();
*/

        //ждем пока не выполнится thread1- thread3 и только потом идем дальше
        //метод .join() -  ждем пока другой поток завершится
  /*      try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       */

     //   thread3.start();
        thread4.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     //   thread3.stop();//рабочий, но плохой способ

   //     thread3.setFinish(true);//остановка не сразу, а через какое-то время, но ждет пока выполнится sleep() в Thread3

        thread4.interrupt();


        System.out.println("end main");

    }

    public static void test() {

    }
}
