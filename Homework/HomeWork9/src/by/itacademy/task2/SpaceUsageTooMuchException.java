package by.itacademy.task2;

public class SpaceUsageTooMuchException extends RuntimeException {
    public SpaceUsageTooMuchException() {
    }

    @Override
    public String getMessage() {
        return "Недостаточно свободного места!";
    }
}
