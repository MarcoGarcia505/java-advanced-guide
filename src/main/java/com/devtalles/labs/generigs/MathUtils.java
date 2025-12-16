package com.devtalles.labs.generigs;

public class MathUtils {
    public static <T extends String> void printString(T value) {
        System.out.println(value);
    }

    public static <T extends Number, K extends String> void printNUmberAndString(T value, K value2){
        System.out.println(value2 + ": " + value);
    }
}
