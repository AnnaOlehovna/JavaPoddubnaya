package by.itacademy.task2;

public class FIO {
    private String surmane;
    private String name;
    private String fatherName;


    public FIO(String surmane, String name, String fatherName) {
        this.surmane = surmane;
        this.name = name;
        this.fatherName = fatherName;
    }

    public String getSurmane() {
        return surmane;
    }

    public void setSurmane(String surmane) {
        this.surmane = surmane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Override
    public String toString() {
        return  surmane +" "+  name+" "+ fatherName;
    }
}
