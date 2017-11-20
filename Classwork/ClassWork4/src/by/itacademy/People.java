package by.itacademy;

/**
 * Created by user on 20.11.2017.
 */
public class People {

    private String name;//private - доступен внутри класса, public - доступен всем
    private int age;
    String surName;// default -тип - доступен только внутри пакета

    public static int staticValue;// статичная переменная единая для всех объектов одного класса


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People() {
    }
}
