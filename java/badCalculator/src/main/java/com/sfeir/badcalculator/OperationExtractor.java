package com.sfeir.badcalculator;

public class OperationExtractor {
    private final String input;

    public OperationExtractor(String inputString) {
        this.input = inputString;
    }

    public String getOperation() {
        int opsi = input.indexOf(' ');
        int opei = input.lastIndexOf(' ');
        String operation = input.substring(opsi + 1, opei);
        return operation;
    }

}
