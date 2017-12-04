package by.itacademy.task1;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 04.12.2017.
 */
public class Main {
    public static void main(String[] args) {

        FileOutputStream fileOutputStream;

        try{
            // блок кода где потенциально может быть проблема

            int a =5/0;

             
            SimpleDateFormat sdf = new SimpleDateFormat("");
            Date date = sdf.parse("qwe");
//
//            fileOutputStream = new FileOutputStream(new File(""));
//            fileOutputStream.write("ggggg");
//
        }catch (ArithmeticException e){
            //блок кода который выполнится, если в блоке try произойдет ошибка - деление на ноль
            System.out.println("Ошибка - деление на ноль " + e.toString());
        } catch (ParseException e) {
            // ошибка парсинг даты
            System.out.println("Ошибка - проблема с датой");
        }catch (Exception e){
            //подходит для всех видов эксшепшена, так как является базовым классом для других видов эксепшена
            // если это в первом catch  - то другие не имеют смысла, они никогда не словятся
        }finally {
            //блок который выполнится в любом случае -  не зависимо от того была ошибка или нет
            System.out.println("finally");
//            if(fileOutputStream!=null){
//                fileOutputStream.close();
//            }
        }

        System.out.println("Продолжение программы");


        try {
            double result = test2(5,0);
        } catch (FiveException e) {
            System.out.println("ошибка, нельзя вводить 5");
        }
    }


    public  static double test(int a, int b) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("");
        Date date = sdf.parse("qwe");
        return 0;
    }


    public  static double test2(int a, int b) throws FiveException {
       if(b==5){
           throw new FiveException();
       }
        return a/b;
    }

}
