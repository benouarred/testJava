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

    private int leftValue;
    private String operation;
    private int rightValue;

    public Integer compute(String input) {
        parseString(input);
        return computeResult();
    }

    private Integer computeResult() {
        log.info("Opération: {}", operation);
        Operation operationObject = Operation.valueOf(operation);
        return operationObject.compute(leftValue, rightValue);
    }

    private void parseString(String input) {
        String[] inputs = input.split("\\s++");
        leftValue = Integer.parseInt(inputs[0]);
        operation = inputs[1];
        rightValue = Integer.parseInt(inputs[2]);
    }


    enum Operation {
        plus {
            @Override
            public Integer compute(int leftValue, int rightValue) {
                return leftValue + rightValue;
            }
        },
        moins {
            @Override
            public Integer compute(int leftValue, int rightValue) {
                return leftValue - rightValue;
            }
        },
        fois {
            @Override
            public Integer compute(int leftValue, int rightValue) {
                return leftValue * rightValue;
            }
        },
        divisé {
            @Override
            public Integer compute(int leftValue, int rightValue) {
                return leftValue / rightValue;
            }
        };

        public abstract Integer compute(int leftValue, int rightValue);
    }
}
