package by.itacademy.task1.CashMachines;

import by.itacademy.task1.Interfaces.Deposit;
import by.itacademy.task1.Interfaces.Withdrawal;

public abstract class BasicCashMashine implements Deposit, Withdrawal {

    private String manufacture;
    private String bankName;
    private int hundredCounter;
    private int fiftyCounter;
    private int twentyCounter;



    public BasicCashMashine(String manufacture, String bankName, int hundredCounter, int fiftyCounter, int twentyCounter) {
        this.manufacture = manufacture;
        this.bankName = bankName;
        this.hundredCounter = hundredCounter;
        this.fiftyCounter = fiftyCounter;
        this.twentyCounter = twentyCounter;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getHundredCounter() {
        return hundredCounter;
    }

    public void setHundredCounter(int hundredCounter) {
        this.hundredCounter = hundredCounter;
    }

    public int getFiftyCounter() {
        return fiftyCounter;
    }

    public void setFiftyCounter(int fiftyCounter) {
        this.fiftyCounter = fiftyCounter;
    }

    public int getTwentyCounter() {
        return twentyCounter;
    }

    public void setTwentyCounter(int twentyCounter) {
        this.twentyCounter = twentyCounter;
    }

    public int sumInMachine() {
        int sum = 100 * hundredCounter
                + 50 * fiftyCounter
                + 20 * twentyCounter;
        return sum;
    }

    @Override
    public boolean deposite(int addSum) {
        boolean isSucceed = false;
        int remainder = addSum;
        int counter = 0;
        if (addSum != 10 && addSum != 30) {
            counter = addSum / 100;
            if (counter != 0) {
                remainder = addSum % (counter * 100);
                hundredCounter = hundredCounter + counter;
                counter = 0;
            }
            if (remainder == 10 || remainder == 30) {
                remainder = remainder + 100;
                hundredCounter = hundredCounter - 1;
            } else if (remainder == 50 || remainder == 70 || remainder == 90) {
                remainder = remainder - 50;
                fiftyCounter = fiftyCounter + 1;
            }
            if (remainder != 0) {
                counter = remainder / 20;
                remainder = 0;
                twentyCounter = twentyCounter + counter;
            }

            if (remainder == 0)
                isSucceed = true;
        }
        return isSucceed;
    }


    @Override
    public int[] withdraw(int money) {
        int[] countOfBanknotes = new int[3];
        int counter = 0;
        int remainder = money;
        if (money > sumInMachine() || money == 10 || money == 30) {
            countOfBanknotes = null;
        } else {
            counter = money / 100;
            if (counter > hundredCounter) {
                remainder = money - 100 * hundredCounter;
                if (remainder == 10 || remainder == 30) {
                    remainder = remainder + 100;
                    counter--;
                    hundredCounter = hundredCounter - counter;
                } else {
                    counter = hundredCounter;
                    hundredCounter = 0;
                }
                countOfBanknotes[0] = counter;
            } else if (counter != 0) {
                remainder = money % (counter * 100);
                if (remainder == 10 || remainder == 30) {
                    remainder = remainder + 100;
                    counter--;
                }
                hundredCounter = hundredCounter - counter;
                countOfBanknotes[0] = counter;
            }
            counter = 0;
            if (remainder != 0 && remainder >= 50) {
                counter = remainder / 50;
                if (counter > fiftyCounter) {
                    counter = fiftyCounter;
                    remainder = remainder - 50 * counter;
                    counter = fiftyCounter;
                    fiftyCounter = 0;
                } else {
                    remainder = remainder % (counter * 50);
                    fiftyCounter = fiftyCounter - counter;
                }
                if (remainder == 10 || remainder == 30) {
                    remainder = remainder + 50;
                    counter--;
                    fiftyCounter = fiftyCounter + 1;
                }
                countOfBanknotes[1] = counter;
            }
            counter = 0;
            if (remainder != 0) {
                counter = remainder / 20;
                if (counter > twentyCounter) {
                    counter = twentyCounter;
                    remainder = remainder - 20 * counter;
                    twentyCounter = 0;
                    countOfBanknotes[2] = counter;
                } else if (counter != 0) {
                    remainder = remainder % (counter * 20);
                    twentyCounter = twentyCounter - counter;
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

