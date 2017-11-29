package by.itacademy.task2;

public class Manager {

    private CashMachine cashMachine;

    public Manager(CashMachine cashMachine) {
        this.cashMachine = cashMachine;
    }

    /**
     * Calculates total amount of money in cash machine
     *
     * @return
     */
    public int sumInMachine() {
        int sum = 100 * cashMachine.getHundredCounter()
                + 50 * cashMachine.getFiftyCounter()
                + 20 * cashMachine.getTwentyCounter();
        return sum;
    }

    /**
     * Adds money in cash machine
     *
     * @param addSum - amount of money to add
     * @return
     */
    public boolean addMoney(int addSum) {
        boolean isSucceed = false;
        int remainder = addSum;
        int counter = 0;
        if (addSum != 10 && addSum != 30) {
            counter = addSum / 100;
            if (counter != 0) {
                remainder = addSum % (counter * 100);
                cashMachine.setHundredCounter(cashMachine.getHundredCounter() + counter);
                counter = 0;
            } else if (remainder == 60 || remainder == 80) {
                counter = remainder / 20;
                remainder = 0;
                cashMachine.setTwentyCounter(cashMachine.getTwentyCounter() + counter);
            }
            if (remainder == 10 || remainder == 30) {
                remainder = remainder + 100;
                cashMachine.setHundredCounter(cashMachine.getHundredCounter() - 1);
            }
            if (remainder >= 50) {
                remainder = remainder - 50;
                cashMachine.setFiftyCounter(cashMachine.getFiftyCounter() + 1);
                counter = remainder / 20;
                remainder = 0;
                cashMachine.setTwentyCounter(cashMachine.getTwentyCounter() + counter);
            }
            if (remainder == 0)
                isSucceed = true;
        }
        return isSucceed;
    }

    /**
     * Withdrawal money from cash machine;
     *
     * @param money - amount of money to withdrawal
     * @return - array of number of banknotes to give out
     */
    public int[] withdrawMoney(int money) {
        int[] countOfBanknotes = new int[3];
        int counter = 0;
        int reminder=money;
        if (money > sumInMachine()) {
            countOfBanknotes = null;
        } else {
           counter= money/100;
           if(counter>cashMachine.getHundredCounter()){
               counter=cashMachine.getHundredCounter();
               reminder=money-100*counter;
               cashMachine.setHundredCounter(0);
           }else {
               reminder = money % (counter * 100);
               cashMachine.setHundredCounter(cashMachine.getHundredCounter() - counter);
           }
        }
        return countOfBanknotes;
    }


}
