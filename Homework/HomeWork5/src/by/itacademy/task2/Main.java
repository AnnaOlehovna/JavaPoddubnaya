package by.itacademy.task2;

public class Main {
    public static void main(String[] args) {

        CashMachine cashMachine= new CashMachine(0,0,0);
        Manager manager = new Manager();
        System.out.println(manager.sumInMachine());

//       if( manager.addMoney(150)==true){
//           System.out.println("Successfully");
//           System.out.println(manager.sumInMachine());
//       }


    }
}
