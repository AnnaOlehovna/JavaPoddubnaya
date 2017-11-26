package by.itacademy.task1;

public abstract class Appliances {

    private String manifacture;
      private int year;
    private int color;

    public Appliances() {
    }

    public Appliances(String manifacture, int year, int color) {
        this.manifacture = manifacture;
        this.year = year;
        this.color = color;
    }

    public String getManifacture() {
        return manifacture;
    }

    public void setManifacture(String manifacture) {
        this.manifacture = manifacture;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public abstract void work();

    public abstract void move();
}
