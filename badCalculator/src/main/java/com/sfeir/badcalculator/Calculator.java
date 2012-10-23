package com.sfeir.badcalculator;

public class Calculator {

    public static void main(String[] args) {
        System.out.println(Calculator.compute("3 plus 4"));
        System.out.println(Calculator.compute("3 moins 4"));
        System.out.println(Calculator.compute("3 fois 4"));
        System.out.println(Calculator.compute("3 divisé 4"));
    }

    private static Integer compute(String input) {
        int opsi = input.indexOf(' ');
        int opei = input.lastIndexOf(' ');
        String operation = input.substring(opsi + 1, opei);

        //System.out.println("_" + operation + "_");

        int leftValue = Integer.parseInt(input.substring(0, input.indexOf(' ')));
        int rightValue = Integer.parseInt(input.substring(input.lastIndexOf(' ') + 1));

        if("plus".equals(operation)) {
            System.out.println("Plus");
            return leftValue + rightValue;
        } else if ("moins".equals(operation)) {
            System.out.println("Moins");
            return leftValue - rightValue;
        } else if ("fois".equals(operation)) {
            System.out.println("Fois");
            return leftValue * rightValue;
        }  else if ("divisé".equals(operation)) {
            System.out.println("Divisé");
            return leftValue / rightValue;
        }

        return null;
    }
}
