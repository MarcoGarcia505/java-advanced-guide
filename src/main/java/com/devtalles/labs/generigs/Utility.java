package com.devtalles.labs.generigs;

public class Utility {
    public static <T> void printData(T value) {
        System.out.println(value);
    }

    public static <T,K,L> void printData(T value1, K value2, L value3){
        System.out.println(value1 + " - " + value2 + " - " + value3);
    }
}
