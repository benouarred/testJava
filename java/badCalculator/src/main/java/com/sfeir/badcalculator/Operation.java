package com.sfeir.badcalculator;

public class Operation {

    private static String input;
    private int left;
    private int right;


    private static OperationExtractor extractor;

    private String operation;

    public static Integer compute(String inputString) {
        input = inputString;
        extractor = new OperationExtractor(inputString);
        int opsi = input.indexOf(' ');
        int opei = input.lastIndexOf(' ');
        String operation = input.substring(opsi + 1, opei);

        //System.out.println("_" + operation + "_");

        if(operation == "plus") {
            System.out.println("Plus");
            return Integer.parseInt(input.substring(0, input.indexOf(' '))) + Integer.parseInt(input.substring(input.lastIndexOf(' ') + 1));
        } else if (operation == "moins") {
            System.out.println("Moins");
            return Integer.parseInt(input.substring(0, input.indexOf(' '))) - Integer.parseInt(input.substring(input.lastIndexOf(' ') + 1));
        } else if (operation == "fois") {
            System.out.println("Fois");
            return Integer.parseInt(input.substring(0, input.indexOf(' '))) * Integer.parseInt(input.substring(input.lastIndexOf(' ') + 1));
        }  else if (operation == "divisé") {
            System.out.println("Divis�");
            return Integer.parseInt(input.substring(0, input.indexOf(' '))) / Integer.parseInt(input.substring(input.lastIndexOf(' ') + 1));
        }

        return null;

    }

    public int getLeft() {
        return Integer.parseInt(input.substring(0, input.indexOf(' ')));
    }

    public int getRight() {
        return Integer.parseInt(input.substring(input.lastIndexOf(' ') + 1));
    }

    public OperationExtractor getExtractor() {
        return extractor;
    }
}
