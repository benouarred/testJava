package com.sfeir.badcalculator;

class Operation {

    private static String input;


    static int compute(String inputString) {
        input = inputString;
        int opsi = input.indexOf(' ');
        int opei = input.lastIndexOf(' ');
        String operation = input.substring(opsi + 1, opei);

        switch (operation) {
            case "plus":
                return add();
            case "moins":
                return sub();
            case "fois":
                return mult();
            case "divise":
                return divide();
        }
        throw new OperationException();

    }


    private static int divide() {
        System.out.println("Divise");
        return Integer.parseInt(String.valueOf(getLeft() / getRight()));
    }

    private static int mult() {
        System.out.println("Fois");
        return Integer.parseInt(String.valueOf(getLeft() * getRight()));
    }

    private static int sub() {
        System.out.println("Moins");
        return Integer.parseInt(String.valueOf(getLeft() - getRight()));
    }

    private static int add() {
        System.out.println("Plus");
        return Integer.parseInt(String.valueOf(getLeft() + getRight()));
    }

    static int getLeft() {
        return Integer.parseInt(input.substring(0, input.indexOf(' ')));
    }

    static int getRight() {
        return Integer.parseInt(input.substring(input.lastIndexOf(' ') + 1));
    }

}
