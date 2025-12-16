package com.devtalles.labs.functional_programing.pure_function;


// Las funciones tienen dependencias externas o modificaciones externas
public class NoPureFunction {
    public static int number; // comparte el estado (Efecto colateral)

    public static int counter(int x) {
        return number += x; // modifica el estado
    }

    public static void main(String[] args) {
        System.out.println("Aumnet: " + counter(5));
        System.out.println("Aumnet: " + counter(5));
    }
}
