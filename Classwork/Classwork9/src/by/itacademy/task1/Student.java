package by.itacademy.task1;

/**
 * Created by user on 08.12.2017.
 */
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

//    //одинаковые студенты, если имена одинаковые, на возраст не обращаем значение
//    @Override
//    public boolean equals(Object obj) {
//        Student student = (Student)obj;
//        return name.equals(student.getName());
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }
//if(name != null){result = name.hashCode()} else{result =0} - расшифровка второй строки в методе, там сокращенный if
    //hashcode - чаще всего уникальный int код, но из-за конечных границ int  - могут случаться повторения
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
