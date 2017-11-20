package by.itacademy.task2;

public class Main {

    public static void main(String[] arg){
        System.out.println(calculateNumberOfPages(231));
    }

    public static int calculateNumberOfPages(int numberOfNotes){
        int numberOfPages=numberOfNotes/10;
        if(numberOfNotes%10!=0){
            numberOfPages++;
        }
    return numberOfPages;
    }

}
