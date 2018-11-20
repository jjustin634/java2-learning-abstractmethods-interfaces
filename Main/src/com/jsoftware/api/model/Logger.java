package com.jsoftware.api.model;

public class Logger {
    public static void log(String m, boolean isSameLine) {
        if (isSameLine) {
            System.out.print(m);
        } else {
            System.out.println(m);
        }
    }

    public static void log(String m) {
        System.out.println(m);
    }
}
