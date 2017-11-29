package by.itacademy.task2;

public class Main {
    public static void main(String[] args) {

        CashMachine cashMachine = new CashMachine(8, 6, 5);
        Manager manager = new Manager(cashMachine);
        System.out.println(manager.sumInMachine());

        if (manager.addMoney(90)) {
            System.out.println("Successfully");
            System.out.println(manager.sumInMachine());
        } else {
            System.out.println("You couldn't add this sum");
        }

//        int[] array = manager.withdrawMoney(130);
//        if (array == null) {
//            System.out.println("Not enough money");
//        } else {
//            System.out.printf("Withdrawal was successful.%n100 - " + array[0] + "%n50 - " + array[1] + "%n20 - " + array[2]+"%n");
//        }
    }
}
