package by.itacademy.task2;

public class MyThread extends Thread {

    private static Main main = new Main();


    @Override
    public void run() {
        int counter =1;
        for (int i = 0; i < 10; i++) {
            counter=main.print10(counter);

            //это чтобы проверить, что синхронизация именно по методу print10()- выдает порциями по 10
            if (Thread.currentThread().getName().equals("myThread1")){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) { }
            }else{
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) { }
            }
        }

    }
}
