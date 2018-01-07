package by.itacademy.task3;

public class CashMachine {


    private int hundredCounter;

    private int fiftyCounter;

    private int twentyCounter;


    public CashMachine() {
    }

    public CashMachine(int hundredCounter, int fiftyCounter, int twentyCounter) {
        this.hundredCounter = hundredCounter;
        this.fiftyCounter = fiftyCounter;
        this.twentyCounter = twentyCounter;
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

}
