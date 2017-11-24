package by.itacademy.task1;

/**
 * Created by user on 24.11.2017.
 */
public class Main {
    public static void main(String[] args) {

        Pacient pacient = new Pacient("w",2,"er","wer");
        pacient.setName("Harry");
        pacient.setDoctorName("Tom Reddle");

        People people1 = new Pacient("uyt",5,"ui","oi");








//     StringBuilder
//      StringBuffer - для многопоточных

       String text = "a"+"b"+"c"+"dsa";

       String text3="a".concat("b");

        StringBuilder builder=new StringBuilder();
        builder.append("a");
        builder.append("b");
        builder.append("c");
        builder.append("dsa");
        String text2=builder.toString();

    }
    /* HomeWork4
    Patient[] patientAr =new Patient[]();

    for(Patient patient: patientAr){
    if(patient.getName.contain(name)){
    print
    }
    }

    */
}
