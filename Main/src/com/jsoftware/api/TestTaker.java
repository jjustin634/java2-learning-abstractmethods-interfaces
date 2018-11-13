package com.jsoftware.api;

import java.util.Scanner;

public class TestTaker {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        log("Welcome to the TestTaker program!");
        log("What test would you like to take? ");
        String testLoading = input.next();

        // use the load method to load the test the user created
        log("Test loaded successful!");

        log("Enter 1 to take a whole test or 2 to take a sample test.");
        logger("Your choice: ");
        int wholeOrSampleTest = input.nextInt();

        try {
            if (wholeOrSampleTest == 1) {
                wholeTest();
            } else {
                sampleTest();
            }
        } catch (Exception e) {
            log("invalid response - please enter either 1 for whole Test or 2 for sample test");
        }
    }

    public static void wholeTest() {
        log("----------------------------\n" +
                "The test starts now!\n" +
                "----------------------------");
    }

    public static void sampleTest() {
        log("----------------------------\n" +
                "The test starts now!\n" +
                "----------------------------");
    }

    public static void log(String m) {
        System.out.println(m);
    }

    public static void logger(String m) {
        System.out.print(m);
    }
}
