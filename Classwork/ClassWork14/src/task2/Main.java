package task2;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args)  {

        Test test = new Test();

        Class classTest = test.getClass();

        System.out.println(classTest.getName());//полное имя класса, с пакетами

        System.out.println(classTest.getSimpleName());//имя только класса

        int mod = classTest.getModifiers();

        if(Modifier.isAbstract(mod)){
            System.out.println("Abstract");
        }else{
            System.out.println("Not Abstract");
        }

        if(Modifier.isPublic(mod)){
            System.out.println("Public");
        }else{
            System.out.println("Not Public");
        }


//       Field[] fields = classTest.getFields(); //Только публичные поля
//        for(Field field:fields){
//            System.out.println("field = "+ field.getName());
//        }


        Field[] fields = classTest.getDeclaredFields(); //И публичные и приватные поля
        for(Field field:fields){
            System.out.println("field name = "+ field.getName());
            try {
                field.setAccessible(true);
                System.out.println("field value = "+ (int)field.get(test));

                field.set(test,50);//можно поменять значение
                System.out.println("field NEW value = "+ (int)field.get(test));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


       Method[] methods= classTest.getDeclaredMethods();
        for(Method method:methods){
            System.out.println("method = "+ method.getName());
        }
    }

}
