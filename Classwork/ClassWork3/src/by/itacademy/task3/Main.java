package by.itacademy.task3;

/**
 * Method for square calculation
 */
public class Main {

    public static void main(String[] arg){

        System.out.println(squareCalculate(2));
        System.out.println(triagleCalculate(1,2));
        System.out.println(rectangleCalculate(2,3));
    }

    /**
     *Return square sq
     * @param a - side
     * @return
     */
    public static double squareCalculate(double a){
        double square=a*a;
        return square;
    }

    /**
     * Return triagle sq
     * @param a - side
     * @param h - hight
     * @return
     */
        public static double triagleCalculate(double a, double h){
        double triagle=0.5*a*h;
        return triagle;
    }

    /**
     * Return rectangle sq
     * @param a - one side
     * @param b - another side
     * @return
     */

    public static double rectangleCalculate(double a,double b) {
        double rectangle = a * b;
        return rectangle;
    }

}
