package by.itacademy.task1.domein.usecase;

import by.itacademy.task1.domein.entity.GetMoneyREsult;
import by.itacademy.task1.domein.entity.Money;
import by.itacademy.task1.domein.repository.MoneyRepository;



public class GetMoneyUseCase implements UseCase {

    private MoneyRepository moneyRepository;


    public GetMoneyUseCase(MoneyRepository moneyRepository){
        this.moneyRepository=moneyRepository;
    }

    public void execute(Money money, GetMoneyListener getMoneyListener){

        //получаем текущее значение денег в банкомате
        Money currentMoney = moneyRepository.get();


        //проверяем достаточно ли денег
        if(currentMoney.getAmount()>=money.getAmount()){

            Money newMoney = new Money();
            newMoney.setAmount(currentMoney.getAmount() - money.getAmount());

            //сохраняем новое количество денег
            moneyRepository.save(newMoney);

           //возвращаем результат в presentation слой
            GetMoneyREsult rEsult = new GetMoneyREsult();
            getMoneyListener.onResult(rEsult);

        }else{

            //возвращаем ошибку в presentation слой
            getMoneyListener.onError();
        }
    }


    //реализация в слое presentation
   public interface GetMoneyListener{
        void onResult(GetMoneyREsult getMoneyResult);
        void onError();
    }
}
