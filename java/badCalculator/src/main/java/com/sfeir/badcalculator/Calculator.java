package com.sfeir.badcalculator;

public class Calculator {

    public static void main(String[] args) {
        Calculator.compute("3 plus 4");
        Calculator.compute("3 moins 4");
        Calculator.compute("3 fois 4");
        Calculator.compute("3 divise 4");
    }

    static void compute(String input) {
        displayResult(Operation.compute(input));
    }

    private static void displayResult(int result) {
        String displayResult = "" + Operation.getLeft();
        displayResult += " " + Operation.getRight();
        displayResult += " = " + result;

        System.out.println(displayResult);
    }
}
