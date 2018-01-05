package task3;


public class Main {

    private static AbstractClass abs = new AbstractClass() {
        @Override
        public void test() {

        }
    };

    public static void main(String[] args) {
     //анонимный класс
        makeSmth(abs);
     //Или вот так
        makeSmth(new AbstractClass() {
            @Override
            public void test() {

            }
        });


    }




    public static void makeSmth(AbstractClass obj){
        obj.test();
    }


}
