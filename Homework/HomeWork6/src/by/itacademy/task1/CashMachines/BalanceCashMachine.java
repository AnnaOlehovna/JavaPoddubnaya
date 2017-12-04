package by.itacademy.task1.CashMachines;

import by.itacademy.task1.Interfaces.NumberOfBanknots;

public class BalanceCashMachine extends BasicCashMashine implements NumberOfBanknots {


    public BalanceCashMachine(String manufacture, String bankName, int hundredCounter, int fiftyCounter, int twentyCounter) {
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
