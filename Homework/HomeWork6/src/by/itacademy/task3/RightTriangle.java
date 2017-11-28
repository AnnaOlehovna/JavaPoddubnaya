package by.itacademy.task3;

public class RightTriangle implements Shape{

   private double hypothesis;
   private double aCathetus;
   private double bAngle;

    public RightTriangle( double aCethetus, double bAngle) {
        this.aCathetus = aCethetus;
        this.bAngle = bAngle;
    }

    @Override
    public double calculateSq() {
        double rightTriagSq=0.5* Math.pow(aCathetus,2) *Math.tan(bAngle);
        return rightTriagSq;
    }



}
