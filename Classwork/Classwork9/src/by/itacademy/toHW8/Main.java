package by.itacademy.toHW8;

/**
 * Created by user on 08.12.2017.
 */
public class Main {
    public static void main(String[] args) {



        try{
            test(5);

        }catch (MyException e){
            System.out.println(e.getRussianMessage());
        }
    }


    public static void test(int a) throws MyException{
        if(a ==5){
            throw new MyException("5 недопустимый метод");
        }
    }

}
