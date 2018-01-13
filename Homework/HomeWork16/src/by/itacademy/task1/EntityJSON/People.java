package by.itacademy.task1.EntityJSON;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 15.12.2017.
 */
public class People {

    private int id;

    @SerializedName("name")
    private String firstName;

    private String surname;
    private int age;
    private boolean isDegree;

    public People(int id, String name, String surname, int age, boolean isDegree) {
        this.id = id;
        this.firstName = name;
        this.surname = surname;
        this.age = age;
        this.isDegree = isDegree;
    }

    public People() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDegree() {
        return isDegree;
    }

    public void setDegree(boolean degree) {
        isDegree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (id != people.id) return false;
        if (age != people.age) return false;
        if (isDegree != people.isDegree) return false;
        if (firstName != null ? !firstName.equals(people.firstName) : people.firstName != null) return false;
        return surname != null ? surname.equals(people.surname) : people.surname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (isDegree ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", isDegree=" + isDegree +
                '}';
    }
}

