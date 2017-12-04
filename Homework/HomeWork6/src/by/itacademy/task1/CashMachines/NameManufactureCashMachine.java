package by.itacademy.task1.CashMachines;

import by.itacademy.task1.Interfaces.BankName;
import by.itacademy.task1.Interfaces.Manufacture;

public class NameManufactureCashMachine extends BasicCashMashine implements BankName,Manufacture {


    public NameManufactureCashMachine(String manufacture, String bankName, int hundredCounter, int fiftyCounter, int twentyCounter) {
        super(manufacture, bankName, hundredCounter, fiftyCounter, twentyCounter);
    }

    @Override
    public String bankName() {
        String bankName=super.getBankName();
        return bankName;
    }

    @Override
    public String manifacture() {
        String manifacture =  super.getManufacture();
        return manifacture;
    }
}
