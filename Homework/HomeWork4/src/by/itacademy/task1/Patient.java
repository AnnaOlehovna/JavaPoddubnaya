package by.itacademy.task1;

public class Patient {

    private String fullName;
    private int age;
    private String roomNumber;
    private boolean inHospitale;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String isInHospitale() {
        String answer = null;
        if (inHospitale) {
            answer = "- В больнице.";
        } else {
            answer = "- Выписан";
        }
        return answer;
    }

    public void setInHospitale(boolean inHospitale) {
        this.inHospitale = inHospitale;
    }


}
