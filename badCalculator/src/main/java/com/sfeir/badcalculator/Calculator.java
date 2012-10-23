package com.sfeir.badcalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.compute("3 plus 4"));
        System.out.println(calculator.compute("3 moins 4"));
        System.out.println(calculator.compute("3 fois 4"));
        System.out.println(calculator.compute("3 divisé 4"));
    }

    Logger log = LoggerFactory.getLogger(Calculator.class);

    public Integer compute(String input) {
        int opsi = input.indexOf(' ');
        int opei = input.lastIndexOf(' ');
        String operation = input.substring(opsi + 1, opei);

        //System.out.println("_" + operation + "_");

        int leftValue = Integer.parseInt(input.substring(0, input.indexOf(' ')));
        int rightValue = Integer.parseInt(input.substring(input.lastIndexOf(' ') + 1));

        log.info("Opération: {}", operation);
        if("plus".equals(operation)) {
            return leftValue + rightValue;
        } else if ("moins".equals(operation)) {
            return leftValue - rightValue;
        } else if ("fois".equals(operation)) {
            return leftValue * rightValue;
        }  else if ("divisé".equals(operation)) {
            return leftValue / rightValue;
        }

        return null;
    }
}
