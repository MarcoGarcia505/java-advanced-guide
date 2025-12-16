package com.devtalles.labs.functional_programing.functional_interface.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CollectionsExample {
    public static void main(String[] args) {
        // Lista la cual no podemos hacer una mutacion
        List<String> names = Arrays.asList("coco1", "coco2", "coco3");

        // forEach recive una funcion anonima llamada Cusumer el cual no retorna nada
        names.forEach(System.out::println);

        // Funcion anoniama que recive ForEach
        Consumer<String> print = (text) -> System.out.println(text);
        names.forEach(print);



        // Lista la cual podemos mutar (editar, crear, eliminar);
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6,7,7));
        numbers.removeIf((number) -> number%2 == 0);
        System.out.println(numbers);

        List<String> words = new ArrayList<>(List.of("coco1", "coco2", "coco3"));
        // UnaryOperator se encarga de recivir el mismo tipo de dato y retornar el mismo tipo -> String - String
        words.replaceAll((word) -> {
            if (word.equals("coco1")) {
                return "quesadilla";
            } else {
                return word;
            }
        });

        System.out.println(words);
    }
}
