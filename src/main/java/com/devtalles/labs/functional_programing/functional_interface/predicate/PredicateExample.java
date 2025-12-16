package com.devtalles.labs.functional_programing.functional_interface.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        // Interfaces funcionales definidas por Java

        // Integer -> valor de entrada
        Predicate<Integer> isEven = (x) -> x%2 == 0;

        // ejecucion de la funcion
        boolean result = isEven.test(10);

        // BiPredicate -> Permite resivir mas parametros dentro de la funcion
        BiPredicate<String, Integer> checkLength = (text, numberCharacter) -> text.length() == numberCharacter;
        // Ejecucion de la funcion
        boolean validateLength = checkLength.test("Local", 5);

        System.out.println("Is par? " + result);
        System.out.println("Has the same length? " + validateLength);


    }
}
