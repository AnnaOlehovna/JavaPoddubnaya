package by.itacademy.task1;

public class Patient {

    private String fullName;
    private int age;
    private String phoneNumber;
    private boolean inHospitale;


    public Patient() {

    }

    public Patient(String fullName, int age, String phoneNumber, boolean inHospitale) {
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.inHospitale = inHospitale;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String isInHospitale() {
        String answer;
        if (inHospitale == true) {
            answer = "находится в больнице";
        } else {
            answer = "выписан";
        }
        return answer;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setInHospitale(boolean inHospitale) {
        this.inHospitale = inHospitale;
    }
    //
//    public void searchPatient() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.printf("Введите 1, если хотите осуществить поиск пациента по ФИО" +
//                " %nВведите 2, если хотите найти пациента по возрасту " +
//                "%nВведите 3, если хотите выйти из поиска%n");
//        int index = scanner.nextInt();
//        switch (index) {
//            case 1:
//                System.out.println("поиск по фио");
//                break;
//            case 2:
//                System.out.println("поиск по возрасту");
//                break;
//            case 3:
//                goodbyeMessage();
//                break;
//            default:
//                System.out.println("Неверный ввод");
//                searchPatient();
//        }
//    }


}
