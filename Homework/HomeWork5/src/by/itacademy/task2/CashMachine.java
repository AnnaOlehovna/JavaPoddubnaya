package by.itacademy.task2;

public class CashMachine {


    private int hundredCounter;

    private int fiftyCounter;

    private int twenryCounter;


    public CashMachine() {
    }

    public CashMachine(int hundredCounter, int fiftyCounter, int twenryCounter) {
        this.hundredCounter = hundredCounter;
        this.fiftyCounter = fiftyCounter;
        this.twenryCounter = twenryCounter;
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


    public int getTwenryCounter() {
        return twenryCounter;
    }

    public void setTwenryCounter(int twenryCounter) {
        this.twenryCounter = twenryCounter;
    }

}
