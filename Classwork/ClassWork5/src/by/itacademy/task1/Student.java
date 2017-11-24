package by.itacademy.task1;

/**
 * Created by user on 24.11.2017.
 */
public class Student extends People {

    private String numberStudentCard;

    public Student(String name, int age, String address, String passport) {
        super(name, age, address, passport);
    }

    public String getNumberStudentCard() {
        return numberStudentCard;
    }

    public void setNumberStudentCard(String numberStudentCard) {
        this.numberStudentCard = numberStudentCard;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
