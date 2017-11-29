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
        int remainder = money;
        if (money > sumInMachine() || money == 10 || money == 30) {
            countOfBanknotes = null;
        } else {
            counter = money / 100;
            if (counter > cashMachine.getHundredCounter()) {
                remainder = money - 100 * cashMachine.getHundredCounter();
                if (remainder == 10 || remainder == 30) {
                    remainder = remainder + 100;
                    counter--;
                    cashMachine.setHundredCounter(cashMachine.getHundredCounter() - counter);
                } else {
                    counter = cashMachine.getHundredCounter();
                    cashMachine.setHundredCounter(0);
                }
                countOfBanknotes[0] = counter;
            } else {
                remainder = money % (counter * 100);
                if (remainder == 10 || remainder == 30) {
                    remainder = remainder + 100;
                    counter--;
                }
                cashMachine.setHundredCounter(cashMachine.getHundredCounter() - counter);
                countOfBanknotes[0] = counter;
            }
            counter = 0;
            if (remainder == 60 || remainder == 80) {
                countOfBanknotes[1] = 0;
                counter = remainder / 20;
                countOfBanknotes[2] = counter;
                remainder = 0;
                cashMachine.setTwentyCounter(cashMachine.getTwentyCounter() - counter);
            } else if (remainder != 0&&remainder>=50) {
                counter = remainder / 50;
                if (counter > cashMachine.getFiftyCounter()) {
                    remainder = remainder - 50 * cashMachine.getFiftyCounter();
                    counter = cashMachine.getFiftyCounter();
                    cashMachine.setFiftyCounter(0);
                } else {
                    remainder = remainder % (counter * 50);
                    cashMachine.setFiftyCounter(cashMachine.getFiftyCounter() - counter);

                }
                countOfBanknotes[1] = counter;

            }
            counter = 0;
            if (remainder != 0) {
                counter = remainder / 20;
                if (counter > cashMachine.getTwentyCounter()) {
                    counter = cashMachine.getTwentyCounter();
                    remainder = remainder - 20 * counter;
                    cashMachine.setTwentyCounter(0);
                    countOfBanknotes[2] = counter;
                } else if(counter!=0){
                    remainder = remainder % (counter * 20);
                    cashMachine.setTwentyCounter(cashMachine.getTwentyCounter() - counter);
                    countOfBanknotes[2] = counter;
                }
            } else {
                countOfBanknotes[2] = 0;
            }
        }

        if (remainder != 0) {
            countOfBanknotes = null;
        }
        return countOfBanknotes;
    }

}
