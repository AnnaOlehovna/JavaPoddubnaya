package task2;

/**
 * Created by user on 09.01.2018.
 */
public class Main2 {

    //volatile - запрещает потокам делать локальные копии переменных, которые в другом потоке
    private volatile String value;

    public static void main(String[] args) {

        Main2 main2 = new Main2();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                main2.value = "asasasas";
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                main2.value=main2.value + "SSSS";
            }
        });

        thread.start();
        thread2.start();

    }
}
