package by.itacademy.Lesson6.Task4;

/**
 * Created by daryatratseuskaya on 11/27/17
 */
public class Button {

    private UI ui;

    // записываем в Button ссылку на Main
    // чтобы Button мог вызвать методы у Main
    public void setMain(UI ui) {
        this.ui = ui;
    }

    // симулируем нажатие на кнопку, это чисто тестовый метод
    // в реальности он приватный
    public void emulateClickOnButton(){
        if (ui != null) ui.onClick();

    }
}
