package by.itacademy.task1;

/**
 * Created by user on 08.01.2018.
 */
public class Thread3 extends Thread {

    private boolean isFinish;

    public void setFinish(boolean finish){
        isFinish = finish;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {

            if(isFinish)
            {//здесь пишем всё что надо сделать(закрыть файлы, сохранение и др.), до того как остановить поток
                //но если sleep долгое - то будем ждать то время - а потом уже закроется поток
                return;}
            System.out.println("thread3 i= "+i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {}
        }



    }
}
