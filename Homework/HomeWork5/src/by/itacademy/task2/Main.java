package by.itacademy.task2;

public class Main {
    public static void main(String[] args) {

        CashMachine cashMachine= new CashMachine(8,0,0);
        Manager manager = new Manager(cashMachine);
        System.out.println(manager.sumInMachine());

       if( manager.addMoney(260)==true){
           System.out.println("Successfully");
           System.out.println(manager.sumInMachine());
       }


    }
}
