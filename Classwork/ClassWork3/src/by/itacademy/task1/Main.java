package by.itacademy.task1;

/**
 * Created by user on 17.11.2017.
 */
public class Main {

    public static void main(String[] arv) {

        int a = 6;


        System.out.println("до");
        test(a, 34, "kldfskljfdklj");
        System.out.println("после");
        hello();

    }

    public static void test(int value, int value2, String text) {
        System.out.println("test " + value + " " + value2 + text);
        hello();
    }

    public static void hello() {
        System.out.println("hello");
    }


}


