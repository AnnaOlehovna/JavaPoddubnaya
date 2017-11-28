package by.itacademy.task2;

public class Manager {

    private CashMachine cashMachine;

    public Manager(CashMachine cashMachine) {
        this.cashMachine = cashMachine;
    }

    public int sumInMachine() {
        int sum = 100 * cashMachine.getHundredCounter()
                + 50 * cashMachine.getFiftyCounter()
                + 20 * cashMachine.getTwenryCounter();
        return sum;
    }


    public   boolean addMoney(int addSum) {


        boolean isSucceed = false;
        int remainder = addSum;
        int counter = 0;
        counter = addSum / 100;
        remainder = addSum % (counter * 100);
        cashMachine.setHundredCounter(cashMachine.getHundredCounter() + counter);
        counter = 0;
        if (remainder == 60 || remainder == 80) {
            counter = remainder / 20;
            remainder=0;
            cashMachine.setTwenryCounter(cashMachine.getTwenryCounter() + counter);
        }
        if (remainder == 10 || remainder == 30) {
            remainder = remainder + 100;
            cashMachine.setHundredCounter(cashMachine.getHundredCounter() - 1);
        }
        if (remainder >= 50) {
            remainder = remainder - 50;
            cashMachine.setFiftyCounter(cashMachine.getFiftyCounter() + 1);
            counter = remainder / 20;
            remainder=0;
            cashMachine.setTwenryCounter(cashMachine.getTwenryCounter() + counter);
        }
        if (remainder == 0)
            isSucceed = true;
        return isSucceed;
    }


    private void withdrawMoney(int money) {

    }
}
