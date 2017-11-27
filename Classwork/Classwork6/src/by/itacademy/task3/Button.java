package by.itacademy.task3;

/**
 * Created by user on 27.11.2017.
 */
public class Button {

    private UI ui;
//записываем в Button ссылку на UI, чтобы Button мог вызвать UI
    public void setUi(UI ui) {
        this.ui = ui;
    }


    // симулирует нажатие на кнопку, это чисто тестовый метод
    public void emulateClickButton(){
        if(ui != null){
            ui.onClick();
        }
    }
}
