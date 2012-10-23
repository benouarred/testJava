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
        String[] inputs = input.split("\\s++");
        int leftValue = Integer.parseInt(inputs[0]);
        String operation = inputs[1];
        int rightValue = Integer.parseInt(inputs[2]);

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
