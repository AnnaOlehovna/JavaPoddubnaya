package by.itacademy.task1;

/**
 * Created by user on 27.11.2017.
 */
public class Manager {

    private Patient[] patientArray;

    /**
     * создаем пациентов для тестирования программы
     */
    public void createTestData() {

        patientArray = new Patient[2];
        patientArray[0] = new Patient();
        patientArray[1] = new Patient();
    }

    /**
     * @return возвращает массив пациентов
     */
    public Patient[] getPatientArray() {
        return patientArray;
    }

    /**
     * @param name
     * @return Возвращает пациентов с заданным именем
     */
    public Patient[] searchByName(String name) {
        // поиск по имени
        Patient[] search = new Patient[patientArray.length];
        int i = 0;
        for (Patient patient : patientArray) {
            if (patient.getName().toLowerCase().equals(name.toLowerCase())) {
                search[i] = patient;
                i++;
            }
        }
        Patient[] searchFinal = new Patient[i];

        System.arraycopy(search, 0, searchFinal, 0, i);

        return searchFinal;
    }


    /**
     * @param age
     * @return Возвращает пациентов с заданным возрастом
     */
    public Patient[] searchByAge(int age) {
        //поиск по возрасту
        return null;
    }

}
