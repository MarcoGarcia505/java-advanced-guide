package com.devtalles.labs.functional_programing.pure_function;

import java.util.function.Function;

public class PureFunctionAndReference {
    public static int multiplyByTwo(int x) {
        return x * 2;
    }

    public static void main(String[] args) {
        System.out.println("Pure function");
        System.out.println("The resul: " + multiplyByTwo(10));

        System.out.println("USING FUNCTIONAL PROGRAMING");
        calculateSum();
    }

    public static void calculateSum() {
        Function<Integer, Integer> multy = (x) -> x * 2;
        Integer value = multy.apply(10);

        System.out.println(value);
    }
}

