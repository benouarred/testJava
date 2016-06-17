package com.sfeir.badcalculator;

import java.util.Vector;

public class CalculatorMain {

    private Vector<String> operations;

    private CalculatorMain() {
        operations = new Vector<>();
        operations.add("3 plus 4");
        operations.add("3 moins 4");
        operations.add("3 fois 4");
        operations.add("3 divise 4");
        operations.add("2 plus 6");
        operations.add("2 moins 12");
        operations.add("10 divisé 3");
    }

    public static void main(String[] args) {
        CalculatorMain p = new CalculatorMain();
        p.program();
    }

    private void program() {
        String op = operations.get(0);
        Calculator.compute(op);

        op = operations.get(1);
        Calculator.compute(op);

        op = operations.get(2);
        Calculator.compute(op);

        op = operations.get(3);
        Calculator.compute(op);

        op = operations.get(4);
        Calculator.compute(op);

        op = operations.get(5);
        Calculator.compute(op);


        //TODO compute only plus operation
        Object[] pluses = operations.stream().filter(e -> e.contains("plus")).toArray();
        System.out.println("there's " + pluses.length + " plus operations");

        //TODO compute only fois operation
        Object[] fois = operations.stream().filter(e -> e.contains("fois")).toArray();
        System.out.println("there's " + pluses.length + " fois operations");
    }


}
