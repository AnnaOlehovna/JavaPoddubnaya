package by.itacademy.toHW8;

/**
 * Created by user on 08.12.2017.
 */
public class MyException extends Exception {
    private String russianMessage;

    public  MyException(String russianMessage){
        this.russianMessage=russianMessage;
    }

    public String getRussianMessage() {
        return russianMessage;
    }

    public void setRussianMessage(String russianMessage) {
        this.russianMessage = russianMessage;
    }
}
