package by.itacademy.task1;

public class Main {
    public static void main(String[] args) {

        PatientManager patientManager = new PatientManager();
        Patient[] patients = patientManager.addPatient();
        patientManager.searchPatient(patients);
    }
}

