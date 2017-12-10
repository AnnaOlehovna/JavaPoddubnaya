package by.itacademy.task4;

import java.util.Date;

public class Student {
    private String name;
    private String surName;
    private Date birthDay;

    public Student() {
    }

    public Student(String name, String surName, Date birthDay) {
        this.name = name;
        this.surName = surName;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

}
