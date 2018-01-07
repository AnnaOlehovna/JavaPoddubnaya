package by.itacademy.task3;

public class Main {
    public static void main(String[] args) {

        CashMachine cashMachine = new CashMachine(1, 0, 10);
        Manager manager = new Manager(cashMachine);
        System.out.println(manager.sumInMachine());

        if (manager.addMoney(105)) {
            System.out.println("Successfully");
            System.out.println("New balance " +manager.sumInMachine());
        } else {
            System.out.println("You couldn't add this sum");
        }

        int[] array = manager.withdrawMoney(70);
        if (array == null) {
            System.out.println("Not enough banknotes in the cash machine");
        } else {
            System.out.printf("Withdrawal was successful.%n100 - " + array[0] + "%n50 - " + array[1] + "%n20 - " + array[2]+"%n");
        }
    }
}
