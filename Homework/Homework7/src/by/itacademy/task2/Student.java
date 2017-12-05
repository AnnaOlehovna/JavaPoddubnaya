package by.itacademy.task2;

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

    //    public boolean setBirthDay(String inputString) {
//        boolean isRight = true;
//        Date birthday = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.forLanguageTag("ru"));
//        try {
//            birthday=sdf.parse("11-12-1992");
//        } catch (ParseException e) {
//            isRight=false;
//        }
//        this.birthDay = birthDay;
//        return isRight;
//    }
}
