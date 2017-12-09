package by.itacademy.task1and2;

public class MyException extends Exception{


    public MyException() {
    }


    public void getRussianMessage(){
        System.out.println("Неверный ввод. Число должно быть от 1 до 4.");
    }
}
