package by.itacademy.task1;

/**
 * Created by user on 24.11.2017.
 */
public class Pacient extends People{

    private String cardNumber;
    private String doctorName;

    public Pacient(String name, int age, String address, String passport) {
        super(name, age, address, passport);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
