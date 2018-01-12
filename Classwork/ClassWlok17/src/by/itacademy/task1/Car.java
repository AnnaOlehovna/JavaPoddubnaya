package by.itacademy.task1;

/**
 * Created by user on 12.01.2018.
 */
public class Car {

    private int id;
    private static String name;


    //если интерфейс применяется только к этому классу, то логично его здесь и создать
    interface Listener{
        void onClick();
    }


    //внутренний класс
    class Windows{
        private int idWindow;
        public  String model;

        public void test( ) {
            name = "qwee";
            id = 12;
        }
    }

    //вложенный класс
   static class Windows2{
        private int idWindow;
        public String model;

        public void test( ) {
            name = "yuyuy";
//            id = 123;//ошибка, id не static
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        class Test{
            //если отсюда надо получить переменные, то надо чтобы они были final
        }

        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
