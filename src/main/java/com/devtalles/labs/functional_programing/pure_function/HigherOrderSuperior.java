package com.devtalles.labs.functional_programing.pure_function;

public class HigherOrderSuperior {
    public static void main(String[] args) {
        // funcion de orden superior es cuando se hace envio de funciones por parametro
        int value = applyOperation(10, 10, (x, y) -> x + y);
        System.out.println(value);
    }

    public static int applyOperation(int x, int y, Operate op) {
        int result = op.compute(x, y);
        return result;
    }
}

@FunctionalInterface
interface Operate{
    int compute(int x, int y);
}