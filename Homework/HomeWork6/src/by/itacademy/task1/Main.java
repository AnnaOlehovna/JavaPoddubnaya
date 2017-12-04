package by.itacademy.task1;

import by.itacademy.task1.CashMachines.BalanceCashMachine;
import by.itacademy.task1.CashMachines.BelVEB;
import by.itacademy.task1.CashMachines.NameManufactureCashMachine;
import by.itacademy.task1.CashMachines.SimpleCashMachine;

public class Main {

    public static void main(String[] args) {

        //SimpleCashMachine - deposit, withdrawal, balance
        SimpleCashMachine cashMachine1 = new SimpleCashMachine("NCR", "BSB Bank", 12, 8, 25);
        System.out.println(cashMachine1.sumInMachine());
        printForDeposite(cashMachine1.deposite(170));
        System.out.println(cashMachine1.sumInMachine());
        printForWithdraw(cashMachine1.withdraw(260));

        //BalanceCasnMachine - Simple + balance with number of banknotes
        BalanceCashMachine cashMachine2 = new BalanceCashMachine("NCR", "IdeaBank", 50, 80, 6);
        cashMachine2.numberOfBanknots();
        printForWithdraw(cashMachine2.withdraw(950));
        printForNumberOfBanknotes(cashMachine2.numberOfBanknots());


        //NameAndManifacture - Simple + Name of Bank+ Manifacture of Cash machine;
        NameManufactureCashMachine cashMachine3 = new NameManufactureCashMachine("NCR", "Belarusbank", 0, 0, 0);
        System.out.println(cashMachine3.sumInMachine());
        System.out.println(cashMachine3.manifacture() +" "+cashMachine3.bankName());

        //BelVEB Cash machine;
        BelVEB belVEB = new BelVEB("Diebold",90,120,64);
        printForNumberOfBanknotes(belVEB.numberOfBanknots());
        System.out.println(belVEB.bankName());
        printForDeposite(belVEB.deposite(850));
        System.out.println(belVEB.manifacture());;
        printForWithdraw(belVEB.withdraw(600));

    }


    /**
     * Prints the result of deposite
     * @param isAdded
     */
    public static void printForDeposite(boolean isAdded) {
        if (isAdded) {
            System.out.println("Successfully");
        } else {
            System.out.println("You couldn't add this sum");
        }
    }

    /**
     * Prints the result of withdraw
     * @param array
     */
    public static void printForWithdraw(int[] array) {
        if (array == null) {
            System.out.println("Not enough banknotes in the cash machine");
        } else {
            System.out.printf("Withdrawal was successful.%n100 - " + array[0] + "%n50 - " + array[1] + "%n20 - " + array[2] + "%n");
        }
    }

    /**
     * Prints the balance with amount of each banknotes
     * @param array
     */
    public static void printForNumberOfBanknotes(int[] array) {
        System.out.printf("In this cashmachine: %n100 - " + array[0] + "%n50 - " + array[1] + "%n20 - " + array[2] + ".%nIn summ - " + array[3]+".%n");
    }
}
