package by.itacademy.task1and2;

public class MyZeroException extends Exception {
    public MyZeroException() {
    }

    public void getRussianMessage(){
        System.out.println("Нельзя делить на ноль");
    }
}
