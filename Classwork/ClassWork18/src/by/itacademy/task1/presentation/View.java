package by.itacademy.task1.presentation;
//MVP - Model-View<->Presenter
//MVVM - Model-View->ViewModel

//MVC - Model-View-Controller


public class View {

    private Controller controller;


    public static void main(String[] args) {

        View view = new View();
        view.startUI();
    }


    public View() {
        controller=new Controller(this);
    }



    private void startUI(){
        System.out.println(controller.getHello());
        System.out.println("Вопроооосик?");
        //например, пользлвательно хочет снять деньги
        controller.getMoney();
    }


    //этот метод будет вызывать контроллер,
    // чтобы показать пользователю ответ на запрос о снятии денег
    public void showGetMoneyResult(boolean ok){
        if(ok){
            System.out.println("Деньги сняты");
        }else{
            System.out.println("Ошибка снятия денег");
        }

    }



    public void showMessage(String message){
        System.out.println("Ошибка: "+message);
    }
}
