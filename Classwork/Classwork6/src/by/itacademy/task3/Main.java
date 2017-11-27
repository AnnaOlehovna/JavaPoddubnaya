package by.itacademy.task3;

/**
 * Created by user on 27.11.2017.
 */
public class Main {
    public static void main(String[] args) {
//Создаем нужные элементы
        UI main = new UI();// допусти в UI лежит логика работы с пользователем
        Button button = new Button();//создали кнопку
        button.setUi(main);// скинули ссылку на UI в Button

        //зависли на три сек
       try {
           Thread.sleep(3000);
       }catch (InterruptedException e){}

       //симулируем нажатие на кнопку,  в реальности такого не будет
       button.emulateClickButton();
    }

}
