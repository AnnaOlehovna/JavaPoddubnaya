package by.itacademy.task1.VacuumCleaner;

import by.itacademy.task1.Appliances;

public class VacuumCleaner extends Appliances {

    private int numberOfNozzles;
    private String power;

    public VacuumCleaner(String manifacture, int year, int color, int numberOfNozzles, String power) {
        super(manifacture, year, color);
        this.numberOfNozzles = numberOfNozzles;
        this.power = power;
    }

    public VacuumCleaner() {
    }

    public int getNumberOfNozzles() {
        return numberOfNozzles;
    }

    public void setNumberOfNozzles(int numberOfNozzles) {
        this.numberOfNozzles = numberOfNozzles;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public void work() {
        System.out.println("Vacuum Cleaner suck up dust and dirt");
    }

    @Override
    public void move() {
        System.out.println("Vacuum Cleaner has wheels so you can easily move it without lifting up.");
    }
}
