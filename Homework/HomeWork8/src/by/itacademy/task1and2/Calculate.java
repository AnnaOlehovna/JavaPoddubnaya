package by.itacademy.task1and2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculate {
    private double number1;
    private double number2;
    private double result;

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public void setNum1() {
        Scanner scanner = new Scanner(System.in);
        try {
            this.number1 = scanner.nextDouble();
        } catch (InputMismatchException e) {
            e.getMessage();
            System.out.println("Неверный формат данных");
            setNum1();
        }
    }

    public void setNum2() {
        Scanner scanner = new Scanner(System.in);
        try {
            this.number2 = scanner.nextDouble();
        } catch (InputMismatchException e) {
            e.getMessage();
            System.out.println("Неверный формат данных");
            setNum2();
        }
    }

    private void plus() {
        result = number1 + number2;
    }

    private void minus() {
        result = number1 - number2;
    }

    private void division() throws MyZeroException {
        if (number2 == 0)
            throw new MyZeroException();
            result = number1 / number2;
     }


    private void multiplication() {
        result = number1 * number2;
    }


    public double findResult() {
        Scanner scanner = new Scanner(System.in);
        try {
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    plus();
                    break;
                case 2:
                    minus();
                    break;
                case 3:
                    multiplication();
                    break;
                case 4:
                    try {
                        division();
                    } catch (MyZeroException e) {
                        e.getRussianMessage();
                    }
                    break;
                default:
                    try {
                        checkInput();
                    } catch (MyException e) {
                        e.getRussianMessage();
                    }
            }
        } catch (InputMismatchException e) {
            e.getMessage();
            System.out.println("Неверный тип ввода");
            findResult();
        }
       return result;
    }


    private void checkInput() throws MyException {
        throw new MyException();
    }



}
