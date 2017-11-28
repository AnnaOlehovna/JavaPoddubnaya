package by.itacademy.task2;

public class Main {
    public static void main(String[] args) {

        CashMachine cashMachine = new CashMachine(8, 0, 0);
        Manager manager = new Manager(cashMachine);
        System.out.println(manager.sumInMachine());

        if (manager.addMoney(260)) {
            System.out.println("Successfully");
            System.out.println(manager.sumInMachine());
        } else {
            System.out.println("Error");
        }

        int[] array = manager.withdrawMoney(1000);
        if (array == null) {
            System.out.println("Not enough money");
        } else {
            System.out.printf("Withdrawal was successful.%n100 - " + array[0] + "%n50 - " + array[1] + "%n20 - " + array[2]);
        }
    }
}
