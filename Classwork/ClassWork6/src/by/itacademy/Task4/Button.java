package by.itacademy.task4;

/**
 * Created by user on 27.11.2017.
 */
public class Button {

    private ButtonClick btClick;
//записываем в Button ссылку на UI, чтобы Button мог вызвать UI
    public void setBtClick(ButtonClick btClick) {
        this.btClick = btClick;
    }


    // симулирует нажатие на кнопку, это чисто тестовый метод
    public void emulateClickButton(){
        if(btClick != null){
            btClick.onClick();
        }
    }
}
