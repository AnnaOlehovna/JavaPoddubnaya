package by.itacademy.task1;

//Тема - внутренние классы

public class Main {
    public static void main(String[] args) {

        Car.Windows windows = (new Car()).new Windows();

        String str = windows.model;


        new Car.Listener() {
            @Override
            public void onClick() {

            }
        } ;

        Car.Windows2 windows2 = new Car.Windows2();//не создается новый Car, Windows2 не зависит от Car

    }
}
