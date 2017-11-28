package by.itacademy.Lesson6.Task4New;

/**
 * Created by daryatratseuskaya on 11/27/17
 */
public class Main {

    public static void main(String[] args) {

        //создаем нужные элементы
        UI main = new UI(); // допустим в UI лежит логика работы с пользователем
        Button button = new Button(); // создали кнопку
        button.setButtonClick(main); // закинули ссылку на UI в Button


        // если мы хотим ту же кнопку, но чтобы сообщение о клике
        // приходило в другой объект
        UI2 ui2 = new UI2();
        Button button2 = new Button();
        button2.setButtonClick(ui2);

        //зависли на 3 секунды
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        // симулируем нажатие на кнопку
        // в реальности этого тут не будет
        button.emulateClickOnButton();






    }

  }
