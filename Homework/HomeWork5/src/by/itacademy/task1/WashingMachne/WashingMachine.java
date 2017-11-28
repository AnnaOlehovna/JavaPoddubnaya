package by.itacademy.task1.WashingMachne;

import by.itacademy.task1.Appliances;

public class WashingMachine extends Appliances {

    private String loadingPosition;
    private boolean isDrying;
    private double maxWeight;
    private int numberOfPrograms;

    public WashingMachine(String manifacture, int year, int color, String loadingPosition, boolean isDrying, double maxWeight, int numberOfPrograms) {
        super(manifacture, year, color);
        this.loadingPosition = loadingPosition;
        this.isDrying = isDrying;
        this.maxWeight = maxWeight;
        this.numberOfPrograms = numberOfPrograms;
    }

    public WashingMachine() {
    }

    @Override
    public void work() {
        System.out.println("Washing machine is working hard");
    }

    @Override
    public void move() {
        work();
        System.out.println("And that's why it is vibrating.");
    }
}
