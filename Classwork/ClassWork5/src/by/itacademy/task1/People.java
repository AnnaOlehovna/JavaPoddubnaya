package by.itacademy.task1;

/**
 * final для класса запрещает от него наследоваться, следовательно нельзя от него наследоваться
 * final в методе запрещает переопределять метод в дочернем классе
 * final для переменной запрещает её менять, делает её константой
 */
public class People {
    private String name;
    private  int age;
    private String address;
    private String passport;

    public People(String name, int age, String address, String passport) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.passport = passport;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
