package com.sfeir.badcalculator;

import java.util.Vector;

public class CalculatorMain {

//    static Vector operations = new Vector();
//
//    {
//        operations.add("3 plus 4");
//        operations.add("3 moins 4");
//        operations.add("3 fois 4");
//        operations.add("3 divisï¿½ 4");
//        operations.add("2 plus 6");
//        operations.add("2 moins 12");
//        operations.add("10 divisÃ© 3");
//    }

    public static void main(String[] args) {

    	Vector operations = new Vector();
		
    	operations.add("3 plus 4");
        operations.add("3 moins 4");
        operations.add("3 fois 4");
        operations.add("3 divisé 4");
        operations.add("2 plus 6");
        operations.add("2 moins 12");
        operations.add("10 divisé 3");
    	
        String op = (String) operations.get(0);
        Calculator.compute(op);

        op = (String) operations.get(1);
        Calculator.compute(op);

        op = (String) operations.get(2);
        Calculator.compute(op);

        op = (String) operations.get(3);
        Calculator.compute(op);

        op = (String) operations.get(4);
        Calculator.compute(op);

        op = (String) operations.get(5);
        Calculator.compute(op);


        //TODO compute only plus operation


        //TODO compute only fois operation


    }


}
