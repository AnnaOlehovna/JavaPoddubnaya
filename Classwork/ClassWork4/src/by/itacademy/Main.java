package by.itacademy;

/**
 * Created by user on 20.11.2017.
 */
public class Main {
    public static void main(String[] args){

        People man1= new People("SSSS",30);
//        man1.name="Aaaa"; если паблик
////        man1.age=25;
//        man1.setName("aaaaa");
//        man1.setAge(25);

//
        People man2= new People();// вызывается пустой конструктор
//        man2.name="Bbbbbb";
//        man2.age=55;
        man2.setName("Bbbbb");
        man2.setAge(34);

        printPeople(man1);
        People.staticValue=100;
        System.out.println(People.staticValue);

        printPeople(man2);

        People.staticValue=200;//к статичным переменным обращаются через класс, а не через объект


        System.out.println(People.staticValue);
    }
    public static void printPeople(People people){
        System.out.println("name = "+people.getName());
        System.out.println("age= "+people.getAge());

    }

}
