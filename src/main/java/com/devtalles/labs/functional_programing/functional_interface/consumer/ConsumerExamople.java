package com.devtalles.labs.functional_programing.functional_interface.consumer;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class ConsumerExamople {
    public static void main(String[] args) {
        // Consumer es una funcion propuesta por Java donde solo se
        // encarga de hacer procesos y no retornar nada
        Consumer<String>  toUpperWord = (word) -> {
            System.out.println(word.toUpperCase());
        };
        // ejecucion de la funcion
        toUpperWord.accept("Local host");

        // Acepta dos parametros, teniendo en cuanta que no retorna nada (void)
        BiConsumer<String, Integer> repeatWord = (word, repetTime) -> {
            for (int i = 0; i < repetTime; i++) {
                System.out.println(word);
            }
        };

        repeatWord.accept("Test", 9);

    }
}
