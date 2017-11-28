package by.itacademy.Lesson6.Task4New;

/**
 * Created by daryatratseuskaya on 11/27/17
 */
public class Button {

    private ButtonClick buttonClick;

    // записываем в Button ссылку на Main
    // чтобы Button мог вызвать методы у Main
    public void setButtonClick(ButtonClick buttonClick) {

        this.buttonClick = buttonClick;
    }

    // симулируем нажатие на кнопку, это чисто тестовый метод
    // в реальности он приватный
    public void emulateClickOnButton(){
        if (buttonClick != null) buttonClick.onClick();

    }
}
