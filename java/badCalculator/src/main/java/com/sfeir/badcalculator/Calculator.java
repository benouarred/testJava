package com.sfeir.badcalculator;

public class Calculator {

    public static void main(String[] args) {
        Calculator.compute("3 plus 4");
        Calculator.compute("3 moins 4");
        Calculator.compute("3 fois 4");
        Calculator.compute("3 divise 4");
    }

    public static void compute(int opsi, int opei) {
    	
    	for(Operation o : Operation.values()) {//- remplacer les if par un switch
    		String operation = o.name().toLowerCase();
    		int result = o.eval(opsi, opei);  
    		
    		displayResult(operation, result, opsi, opei);
    	}
    }
    
    public static void compute(String input) {    	
    	String[] elements = input.split(" ");//- remplacer les indexOf par String.split ou une RegExp
    	int opsi = Integer.parseInt(elements[0]);//- supprimer le code dupliqué (Integer.parse ...) par refactoring
        String operation = elements[1];
        int opei = Integer.parseInt(elements[2]);
        
        int result = Operation.valueOf(operation.toUpperCase()).eval(opsi, opei);
        displayResult(operation, result, opsi, opei);
    }
    
    private static void displayResult(String operation, int result, int opsi, int opei) {
        String displayResult = "" + opsi;
        displayResult += " " + operation;
        displayResult += " " + opei;
        displayResult += " = " + result;

        System.out.println(displayResult);
    }
}
