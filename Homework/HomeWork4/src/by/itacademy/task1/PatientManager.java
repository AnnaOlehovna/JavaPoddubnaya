package by.itacademy.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PatientManager {

    private Patient[] patients;

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    /**
     * Adds number of Patient in array
     * @return array of Patient
     */
    public Patient[] addPatient() {
        System.out.println("Введите количество пациентов");
        int amountOfPatient = addInt();
        Patient[] patients = new Patient[amountOfPatient];
        for (int i = 0; i < amountOfPatient; i++) {
            patients[i] = new Patient();
            System.out.printf("Введите ФИО " + (i + 1) + "-го пациента: ");
            patients[i].setFullName(addString());
            System.out.printf("Введите возраст " + (i + 1) + "-го пациента: ");
            patients[i].setAge(addInt());
            System.out.printf("Введите номер палаты " + (i + 1) + "-го пациента: ");
            patients[i].setRoomNumber(addString());
            System.out.printf("Введите 1, если пациент находится в больнице %nИли другую цифру, если пациент выписан: ");
            int index = addInt();
            if (index == 1) {
                patients[i].setInHospitale(true);
            } else {
                patients[i].setInHospitale(false);
            }
        }
        for (Patient patient : patients) {
            System.out.println("Пациент: " + patient.getFullName() + " - Возраст: " + patient.getAge() + ".");
        }

        return patients;
    }

    /**
     * Reads String from console
     * @return
     */
    public  String addString() {
        String inputString = null;
        try {
            BufferedReader fillInString = new BufferedReader(new InputStreamReader(System.in));
            inputString = fillInString.readLine();
        } catch (IOException e) {

        }
        return inputString;
    }

    /**
     * Reads int from console
     * @return
     */
    public  int addInt() {
        int inputInt = 0;
        try {
            BufferedReader fillInInt = new BufferedReader(new InputStreamReader(System.in));
            inputInt = Integer.parseInt(fillInInt.readLine());
        } catch (IOException e) {

        }
        return inputInt;
    }

    /**
     * Search of patients by name or by age
     * @param patients
     */
    public  void searchPatient(Patient[] patients) {
        System.out.printf("Введите 1, если хотите осуществить поиск пациента по ФИО" +
                " %nВведите 2, если хотите найти пациента по возрасту " +
                "%nВведите 3, если хотите выйти из поиска%n");
        int index = addInt();
        switch (index) {
            case 1:
                searchByName(patients);
                break;
            case 2:
                searchByAge(patients);
                break;
            case 3:
                goodbyeMessage();
                break;
            default:
                System.out.println("Неверный ввод");
                searchPatient(patients);
        }
    }

    /**
     * Search of patient by name
     * @param patients
     */
    public  void searchByName(Patient[] patients) {
        System.out.printf("Введите ФИО пациента: ");
        String patientName = addString();
        boolean isFound = false;
        for (int i = 0; i < patients.length; i++) {
            if (patients[i].getFullName().toLowerCase().contains(patientName.toLowerCase())) {
                isFound = true;
                System.out.println("Пациент: " + patients[i].getFullName() + " - Возраст: " + patients[i].getAge() +
                        "- Номер палаты: " + patients[i].getRoomNumber() + patients[i].isInHospitale());
            }
        }
        goodbyeMessage();
        if (!isFound) {
            System.out.println("Извините, такого пациента не найдено");
            goodbyeMessage();
        }
    }

    /**
     * Search of patients by age
     * @param patients
     */
    public  void searchByAge(Patient[] patients) {
        System.out.printf("Введите возраст пациента: ");
        int searchAge = addInt();
        boolean isFound = false;
        for (int i = 0; i < patients.length; i++) {
            if (patients[i].getAge() == searchAge) {
                isFound = true;
                System.out.println("Пациент: " + patients[i].getFullName() + " - Возраст: " + patients[i].getAge() +
                        "- Номер палаты: " + patients[i].getRoomNumber() + patients[i].isInHospitale());
            }
        }
        if (!isFound) {
            System.out.println("Извините, такого пациента не найдено");
            goodbyeMessage();
        }
    }


    /**
     * Writes GoodBye message
     */
    public  void goodbyeMessage() {
        System.out.println("Спасибо, что воспользовались нашими услугами! Всего доброго!");
    }

}
