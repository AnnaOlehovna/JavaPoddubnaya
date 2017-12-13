package by.itacademy.task2;

public class NoSuchRoomException extends Exception {
    public NoSuchRoomException() {
    }

    public NoSuchRoomException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Такой комнаты не существует.";
    }
}
