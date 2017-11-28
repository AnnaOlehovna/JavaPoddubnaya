package by.itacademy.Lesson6.Task4;

/**
 * Created by daryatratseuskaya on 11/27/17
 */
public class Main {

    public static void main(String[] args) {

        //создаем нужные элементы
        UI main = new UI(); // допустим в UI лежит логика работы с пользователем
        Button button = new Button(); // создали кнопку
        button.setMain(main); // закинули ссылку на UI в Button


//        UI2 ui2 = new UI(); // допустим в UI лежит логика работы с пользователем
//        Button button2 = new Button(); // создали кнопку
//        button.setMain(ui2); // закинули ссылку на UI в Button


        //зависли на 3 секунды
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        // симулируем нажатие на кнопку
        // в реальности этого тут не будет
        button.emulateClickOnButton();






    }

  }
