package by.itacademy.task1.CashMachines;

import by.itacademy.task1.Interfaces.BankName;
import by.itacademy.task1.Interfaces.Manufacture;
import by.itacademy.task1.Interfaces.NumberOfBanknots;

public class BelVEB extends BalanceCashMachine implements BankName, Manufacture {

    public BelVEB(String manufacture, int hundredCounter, int fiftyCounter, int twentyCounter) {
        super(manufacture, "БелВЭБ", hundredCounter, fiftyCounter, twentyCounter);
    }

    @Override
    public String bankName() {
        String bankName = "BANK: " + super.getBankName();
        return bankName;
    }

    @Override
    public String manifacture() {
        String manifacture = "Manifacture: " + super.getManufacture();
        return manifacture;
    }


}
