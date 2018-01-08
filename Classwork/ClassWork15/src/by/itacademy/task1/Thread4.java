package by.itacademy.task1;

public class Thread4  extends Thread {

        @Override
        public void run() {

            if(isInterrupted()) {
                System.out.println("stop by if ");
                return;
            }
            for (int i = 0; i <10 ; i++) {
                System.out.println("thread4 i= "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("stop by InterruptedException");
                    return;
                }
            }

        }
    }

