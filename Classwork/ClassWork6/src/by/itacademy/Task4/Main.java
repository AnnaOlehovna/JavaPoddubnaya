package by.itacademy.task4;

/**
 * Created by user on 27.11.2017.
 */
public class Main {
    public static void main(String[] args) {
//Создаем нужные элементы

        UI ui = new UI();// допусти в UI лежит логика работы с пользователем
        Button button = new Button();//создали кнопку
        button.setBtClick(ui);// скинули ссылку на UI в Button

        UI2 ui2 = new UI2();
        Button button2 = new Button();
        button2.setBtClick(ui2);

        //зависли на три сек
       try {
           Thread.sleep(3000);
       }catch (InterruptedException e){}

       //симулируем нажатие на кнопку,  в реальности такого не будет
       button.emulateClickButton();
    }

}
