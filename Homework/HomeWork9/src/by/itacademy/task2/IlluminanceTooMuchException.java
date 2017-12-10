package by.itacademy.task2;

public class IlluminanceTooMuchException extends RuntimeException {
    public IlluminanceTooMuchException() {
    }

    @Override
    public String getMessage() {
        return "Освещенность превысит допустимую норму 4000 лк";
    }
}
