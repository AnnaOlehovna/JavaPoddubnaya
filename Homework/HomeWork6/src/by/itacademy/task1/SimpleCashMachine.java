package by.itacademy.task1;

public class SimpleCashMachine extends BasicCashMashine implements NumberOfBanknots{


    public SimpleCashMachine(String manufacture, String bankName, int hundredCounter, int fiftyCounter, int twentyCounter) {
        super(manufacture, bankName, hundredCounter, fiftyCounter, twentyCounter);
    }

    @Override
    public int[] numberOfBanknots() {
        int[] array = new int[4];
        array[0]=super.getHundredCounter();
        array[1]=super.getFiftyCounter();
        array[2]=super.getTwentyCounter();
        array[3]=sumInMachine();
        return array;
    }
}

