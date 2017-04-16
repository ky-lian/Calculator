package com.company;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0 || args[0].length() == 0) {
            System.out.println("Error: No expression is specified.");
            return;
        }
        try {
            System.out.println("Result: " + SimpleInfixCalculator.evaluate(args[0]).toPlainString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


}
