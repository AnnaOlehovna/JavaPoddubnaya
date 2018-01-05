package task4;

/**
 * Created by user on 05.01.2018.
 */
public class Main {
    public static void main(String[] args) {

//      int money=  getMoney();

        getMoney(50,new OnGetMoneyListener() {
            @Override
            public void onMoney(int money) {
                //вызовется как только деньги отдадут
            }
        });
        //может выполнятся другой код, пока мы ждем ответа
        //показать прогресс бар...

    }

//    public static int getMoney(){
//        return 50;
//    }

    public static void getMoney(int count,OnGetMoneyListener listener){
        //проходит время, выполняется код
        listener.onMoney(50);

    }

    interface OnGetMoneyListener{
        void onMoney(int money);
    }

}
