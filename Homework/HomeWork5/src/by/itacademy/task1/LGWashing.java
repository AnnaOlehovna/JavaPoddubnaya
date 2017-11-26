package by.itacademy.task1;

public class LGWashing extends WashingMachine {
     private String model;

    public LGWashing(int year, int color, String loadingPosition, boolean isDrying, double maxWeight, int numberOfPrograms) {
        super("corpLG", year, color, loadingPosition, isDrying, maxWeight, numberOfPrograms);

    }

    public LGWashing(){
        super.setManifacture("corpLG");
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
