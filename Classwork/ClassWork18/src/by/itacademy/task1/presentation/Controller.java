package by.itacademy.task1.presentation;

import by.itacademy.task1.domein.entity.GetMoneyREsult;
import by.itacademy.task1.domein.entity.Money;
import by.itacademy.task1.domein.usecase.GetMoneyUseCase;

import java.util.ArrayList;

public class Controller {


    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void getMoney(){

        //тут стучимся в UseCase, а затем показываем данные на экране

        //создание потом будет не тут
        GetMoneyUseCase getMoneyUseCase = new GetMoneyUseCase();

        Money money = new Money();
        money.setAmount(100);
        getMoneyUseCase.execute(money, new GetMoneyUseCase.GetMoneyListener() {
            @Override
            public void onResult(GetMoneyREsult getMoneyResult) {

                view.showGetMoneyResult(true);
            }

            @Override
            public void onError() {
                view.showMessage("Деньги не снялись");

            }
        });
    }







    public String getHello(){
        return "hello!";
    }


    public int getInt(){

        view.showMessage("bla-bla");
        return 5;
    }

    public String getDataSortedByNAme(){
        return "sorted!";
    }
}
