package task1;

public class Main {
    public static void main(String[] args) {

        // Manager manager = new Manager(); - нельзя так создать - приватный конструктор



        //создает объект в самом классе Manager через метод getInstance();
        //чтобы класс Manager мог иметь только один объект и всегда вызывался один и тот же объект
        Manager manager = Manager.getInstance();
        manager.setA("aaaaaa");

        Manager manager1 = Manager.getInstance();
        System.out.println(manager1.getA());




    }
}
