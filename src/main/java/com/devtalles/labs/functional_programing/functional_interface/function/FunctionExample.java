package com.devtalles.labs.functional_programing.functional_interface.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        // Function<tipo de dato de entrada, tipo de dato que retorna la funcion>
        Function<String, Integer> stringLength = (text) -> text.length();
        int lenght = stringLength.apply("love is love");
        System.out.println("teh length is: " + lenght);


        // BiFunction<entrada, entrada, tipo de dato de salida>
        BiFunction<Integer, Integer, String> sumString = (q, w) -> "Result: " + (q+w);
        String totalSum = sumString.apply(10, 10);
        System.out.println(totalSum);

    }
}
