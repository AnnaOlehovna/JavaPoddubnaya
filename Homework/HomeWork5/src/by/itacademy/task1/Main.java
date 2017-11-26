package by.itacademy.task1;

public class Main {
    public static void main(String[] args) {

        VacuumCleaner vacuumCleaner=new VacuumCleaner();
        vacuumCleaner.work();
        vacuumCleaner.move();

        LGWashing lgWashing = new LGWashing();
        System.out.println(lgWashing.getManifacture());
        lgWashing.move();


        WaterVacuumCleaner wvc = new WaterVacuumCleaner();
        wvc.work();
        wvc.move();

    }
}
