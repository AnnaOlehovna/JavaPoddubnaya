package by.itacademy.task1.VacuumCleaner;

import by.itacademy.task1.VacuumCleaner.VacuumCleaner;

public class WaterVacuumCleaner extends VacuumCleaner {

    private int waterNozzles;
    private double volumeWaterContainer;

    public WaterVacuumCleaner(String manifacture, int year, int color, int numberOfNozzles, String power, int waterNozzles, double volumeWaterContainer) {
        super(manifacture, year, color, numberOfNozzles, power);
        this.waterNozzles = waterNozzles;
        this.volumeWaterContainer = volumeWaterContainer;
    }

    public WaterVacuumCleaner() {
    }

    public int getWaterNozzles() {
        return waterNozzles;
    }

    public void setWaterNozzles(int waterNozzles) {
        this.waterNozzles = waterNozzles;
    }

    public double getVolumeWaterContainer() {
        return volumeWaterContainer;
    }

    public void setVolumeWaterContainer(double volumeWaterContainer) {
        this.volumeWaterContainer = volumeWaterContainer;
    }

    @Override
    public void work(){
        super.work();
        System.out.println("And WaterVaccumCleaner can also wash the floor");
    }
}
