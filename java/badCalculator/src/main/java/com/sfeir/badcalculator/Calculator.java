package com.sfeir.badcalculator;

public class Calculator {

    public static void main(String[] args) {
        Calculator.compute("3 plus 4");
        Calculator.compute("3 moins 4");
        Calculator.compute("3 fois 4");
        Calculator.compute("3 divis� 4");
    }

    public static void compute(String input) {
        Operation operation = new Operation();
        displayResult(Operation.compute(input), operation);
    }

    private static void displayResult(int result, Operation operation) {
        String displayResult = "" + operation.getLeft();
        displayResult += " " + operation.getExtractor().getOperation();
        displayResult += " " + operation.getRight();
        displayResult += " = " + result;

        System.out.println(displayResult);
    }
}
